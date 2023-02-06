-- Table: app.Jenre

-- DROP TABLE IF EXISTS app."Jenre";

CREATE TABLE IF NOT EXISTS app."Jenre"
(
    id bigint NOT NULL DEFAULT nextval('app."Jenre_id_seq"'::regclass),
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Jenre_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS app."Jenre"
    OWNER to postgres;