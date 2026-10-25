COMPOSE_DEV = docker compose --env-file docker/.env.dev -f docker/docker-compose.yml -f docker/docker-compose.dev.yml
COMPOSE_PROD = docker compose --env-file docker/.env.prod -f docker/docker-compose.yml -f docker/docker-compose.prod.yml

.PHONY: dev-up dev-down dev-clean dev-logs dev-ps dev-restart dev-mysql dev-redis prod-up prod-down prod-restart

# ==========================
# 开发环境
# ==========================
dev-up:
	$(COMPOSE_DEV) up -d

dev-down:
	$(COMPOSE_DEV) down

dev-clean:
	$(COMPOSE_DEV) down -v

dev-logs:
	$(COMPOSE_DEV) logs -f

dev-ps:
	$(COMPOSE_DEV) ps

dev-restart:
	$(COMPOSE_DEV) restart


# ==========================
# 开发调试
# ==========================
dev-mysql:
	$(COMPOSE_DEV) exec mysql mysql -uroot -p

dev-redis:
	$(COMPOSE_DEV) exec redis redis-cli


# ==========================
# 生产环境
# ==========================
prod-up:
	$(COMPOSE_PROD) up -d

prod-down:
	$(COMPOSE_PROD) down

prod-restart:
	$(COMPOSE_PROD) restart