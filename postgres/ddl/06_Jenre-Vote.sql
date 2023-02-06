-- Table: app.Jenre-Voite

-- DROP TABLE IF EXISTS app."Jenre-Voite";

CREATE TABLE IF NOT EXISTS app."Jenre-Voite"
(
    id bigint NOT NULL DEFAULT nextval('app."Jenre-Voite_id_seq"'::regclass),
    "Jenre" text COLLATE pg_catalog."default" NOT NULL,
    "Voite" smallint,
    CONSTRAINT "Jenre-Voite_pkey" PRIMARY KEY (id),
    CONSTRAINT "Jenre-Voite_id_fkey" FOREIGN KEY (id)
        REFERENCES app."Jenre" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS app."Jenre-Voite"
    OWNER to postgres;