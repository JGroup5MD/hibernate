-- Table: app.Artist-Jenre

-- DROP TABLE IF EXISTS app."Artist-Jenre";

CREATE TABLE IF NOT EXISTS app."Artist-Jenre"
(
    id bigint NOT NULL DEFAULT nextval('app."Artist-Jenre_id_seq"'::regclass),
    dt_created timestamp with time zone,
    artist bigint,
    jenre_1 bigint NOT NULL,
    jenre_2 bigint NOT NULL,
    jenre_3 bigint NOT NULL,
    jenre_4 bigint,
    jenre_5 bigint,
    about text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Artist-Jenre_pkey" PRIMARY KEY (id),
    CONSTRAINT "Artist-Jenre_artist_fkey" FOREIGN KEY (artist)
        REFERENCES app."Artist" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "Artist-Jenre_jenre_1_fkey" FOREIGN KEY (jenre_1)
        REFERENCES app."Jenre" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "Artist-Jenre_jenre_2_fkey" FOREIGN KEY (jenre_2)
        REFERENCES app."Jenre" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "Artist-Jenre_jenre_3_fkey" FOREIGN KEY (jenre_3)
        REFERENCES app."Jenre" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "Artist-Jenre_jenre_4_fkey" FOREIGN KEY (jenre_4)
        REFERENCES app."Jenre" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "Artist-Jenre_jenre_5_fkey" FOREIGN KEY (jenre_5)
        REFERENCES app."Jenre" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS app."Artist-Jenre"
    OWNER to postgres;