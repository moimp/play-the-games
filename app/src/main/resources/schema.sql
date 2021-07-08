CREATE TABLE IF NOT EXISTS RANKING(id BIGSERIAL , size integer, version bigint);
CREATE TABLE IF NOT EXISTS RANKING_ITEM(ranking_id bigint, ranking_key integer, user_name varchar(100), score integer, ranked_at timestamp);

CREATE TABLE IF NOT EXISTS HIGH_LOW_PLAYING_CONTEXT(id BIGSERIAL, game_id bigint, user_name varchar(100), start_at timestamp, state varchar(100), target bigint, score integer, version bigint, UNIQUE(game_id, user_name));
CREATE TABLE IF NOT EXISTS PLAYING_CONTEXT(id BIGSERIAL, game_id bigint, user_name varchar(100), start_at timestamp, state varchar(100), score integer, version bigint, UNIQUE(game_id, user_name));

CREATE TABLE IF NOT EXISTS EVENTS (id BIGSERIAL,name varchar(200),domain_event varchar(30000),aggregate_root varchar(20000),occurred_at timestamp);

---