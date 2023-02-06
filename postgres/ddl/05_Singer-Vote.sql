-- Table: app.Artist-Voite

-- DROP TABLE IF EXISTS app."Artist-Voite";

CREATE TABLE IF NOT EXISTS app."Artist-Voite"
(
    id bigint NOT NULL DEFAULT nextval('app."Artist-Voite_id_seq"'::regclass),
    "Singer" text COLLATE pg_catalog."default" NOT NULL,
    "Voite" smallint DEFAULT 0,
    CONSTRAINT "Artist-Voite_pkey" PRIMARY KEY (id),
    CONSTRAINT "Artist-Voite_id_fkey" FOREIGN KEY (id)
        REFERENCES app."Artist" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS app."Artist-Voite"
    OWNER to postgres;