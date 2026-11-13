package com.fogsbridge.yogurt.server.mapper;

import com.fogsbridge.yogurt.server.model.entity.UploadScene;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 上传场景 mapper
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@Mapper
public interface UploadSceneMapper {
    String UK_SCENE_NAME = "uk_scene_name";
    String UK_SCENE_TYPE = "uk_scene_type";
    String UK_BASE_PATH = "uk_scene_path";

    Long insert(UploadScene scene);

    UploadScene selectById(@Param("id") Long id);

    UploadScene selectBySceneNameAndBuiltin(@Param("sceneName") String sceneName, @Param("builtin") Boolean builtin);
}
