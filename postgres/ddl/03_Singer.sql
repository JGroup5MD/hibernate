-- Table: app.Artist

-- DROP TABLE IF EXISTS app."Artist";

CREATE TABLE IF NOT EXISTS app."Artist"
(
    id bigint NOT NULL DEFAULT nextval('app."Artist_id_seq"'::regclass),
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Artist_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS app."Artist"
    OWNER to postgres;