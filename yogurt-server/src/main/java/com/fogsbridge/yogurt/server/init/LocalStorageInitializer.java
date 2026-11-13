package com.fogsbridge.yogurt.server.init;

import com.fogsbridge.yogurt.server.common.enums.AccessLevel;
import com.fogsbridge.yogurt.server.common.enums.FileType;
import com.fogsbridge.yogurt.server.common.enums.SceneType;
import com.fogsbridge.yogurt.server.common.enums.StorageType;
import com.fogsbridge.yogurt.server.config.properties.LocalStorageProperties;
import com.fogsbridge.yogurt.server.mapper.StorageBucketMapper;
import com.fogsbridge.yogurt.server.mapper.StorageSourceMapper;
import com.fogsbridge.yogurt.server.mapper.UploadSceneMapper;
import com.fogsbridge.yogurt.server.model.entity.StorageBucket;
import com.fogsbridge.yogurt.server.model.entity.StorageSource;
import com.fogsbridge.yogurt.server.model.entity.UploadScene;
import org.apache.commons.io.FileUtils;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;


/**
 * 本地存储初始化
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@Component
@Order(1)
public class LocalStorageInitializer implements CommandLineRunner {
    private final StorageSourceMapper sourceMapper;
    private final StorageBucketMapper bucketMapper;
    private final UploadSceneMapper sceneMapper;
    private final LocalStorageProperties localStorageProperties;

    private static final String SOURCE_NAME = "本地存储";

    private static final String ISOLATION_BUCKET_NAME = "isolation";
    private static final String PUBLIC_BUCKET_NAME = "public";

    private static final String AVATAR_SCENE = "头像";
    private static final String AVATAR_BASE_PATH = "avatar";


    public LocalStorageInitializer(StorageSourceMapper sourceMapper, StorageBucketMapper bucketMapper, UploadSceneMapper sceneMapper, LocalStorageProperties localStorageProperties) {
        this.sourceMapper = sourceMapper;
        this.bucketMapper = bucketMapper;
        this.sceneMapper = sceneMapper;
        this.localStorageProperties = localStorageProperties;
    }

    @Override
    public void run(String @NonNull ... args) {
        StorageSource source = getOrCreateStorageSource();
        createStorageBucket(source);
        createUploadScene(source);

        createDirectory(ISOLATION_BUCKET_NAME, AVATAR_BASE_PATH);
        createDirectory(PUBLIC_BUCKET_NAME, AVATAR_BASE_PATH);
    }

    private StorageSource getOrCreateStorageSource() {
        StorageSource source = sourceMapper.selectBySourceNameAndBuiltin(SOURCE_NAME, true);
        if (source == null) {
            source = new StorageSource();
            source.setSourceName(SOURCE_NAME);
            source.setStorageType(StorageType.LOCAL);
            source.setPathStyle(true);
            source.setBuiltin(true);
            sourceMapper.insert(source);
        }
        return source;
    }

    private void createStorageBucket(StorageSource source) {
        if (bucketMapper.selectByBucketNameAndBuiltin(PUBLIC_BUCKET_NAME, true) == null) {
            StorageBucket publicBucket = new StorageBucket();
            publicBucket.setSourceId(source.getId());
            publicBucket.setBucketName(PUBLIC_BUCKET_NAME);
            publicBucket.setAccessLevel(AccessLevel.PUBLIC);
            publicBucket.setBuiltin(true);
            bucketMapper.insert(publicBucket);
        }

        if (bucketMapper.selectByBucketNameAndBuiltin(ISOLATION_BUCKET_NAME, true) == null) {
            StorageBucket isolationBucket = new StorageBucket();
            isolationBucket.setSourceId(source.getId());
            isolationBucket.setBucketName(ISOLATION_BUCKET_NAME);
            isolationBucket.setAccessLevel(AccessLevel.ISOLATION);
            isolationBucket.setBuiltin(true);
            bucketMapper.insert(isolationBucket);
        }
    }

    private void createUploadScene(StorageSource source) {
        if (sceneMapper.selectBySceneNameAndBuiltin(AVATAR_SCENE, true) == null) {
            UploadScene scene = new UploadScene();
            scene.setSourceId(source.getId());
            scene.setSceneName(AVATAR_SCENE);
            scene.setSceneType(SceneType.AVATAR);
            scene.setFileType(FileType.IMAGE);
            scene.setBasePath(AVATAR_BASE_PATH);
            scene.setMaxSize(FileUtils.ONE_MB * 10);
            scene.setChunkSize(0L);
            scene.setAllowedTypes(Set.of("jpg", "jpeg", "png", "webp", "svg", "gif"));
            scene.setBuiltin(true);
            sceneMapper.insert(scene);
        }
    }

    private void createDirectory(String bucketName, String basePath) {
        try {
            Path root = Paths.get(localStorageProperties.getRootPath()).toAbsolutePath().normalize();
            Path targetPath = root.resolve(bucketName).resolve(basePath).normalize();
            FileUtils.forceMkdir(targetPath.toFile());
        } catch (IOException e) {
            throw new RuntimeException("本地存储初始化失败", e);
        }
    }
}
