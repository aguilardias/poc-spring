CREATE TABLE IF NOT EXISTS anuncio (
  id bigint NOT NULL,
  nome character varying(255),
  data_anuncio timestamp without time zone,
  quantidade bigint,
  CONSTRAINT anuncio_pkey PRIMARY KEY (id)
);