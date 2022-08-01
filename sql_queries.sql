BEGIN;

CREATE TABLE IF NOT EXISTS public.User
(
    id bigserial NOT NULL,
    first_name character varying(100) NOT NULL,
    last_name character varying(100) NOT NULL,
    email character varying(150) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.Dealership
(
    id bigserial NOT NULL,
    dealership_name character varying(150) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.AddressLocation
(
    id bigserial NOT NULL,
    stateTerritory character varying(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.Review
(
    id bigserial NOT NULL,
    reviews character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.Review_AddressLocation
(
    Review_id bigint NOT NULL,
    AddressLocation_id bigint NOT NULL,
    id bigserial NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.Dealership_Review_AddressLocation
(
    Dealership_id bigint NOT NULL,
    Review_AddressLocation_id bigint NOT NULL,
    id bigserial NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.Review_AddressLocation
    ADD FOREIGN KEY (Review_id)
    REFERENCES public.Review (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.Review_AddressLocation
    ADD FOREIGN KEY (AddressLocation_id)
    REFERENCES public.AddressLocation (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.Dealership_Review_AddressLocation
    ADD FOREIGN KEY (Dealership_id)
    REFERENCES public.Dealership (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.Dealership_Review_AddressLocation
    ADD FOREIGN KEY (Review_AddressLocation_id)
    REFERENCES public.Review_AddressLocation (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

--Reviews
INSERT INTO Review (id, reviews) VALUES (1, 'Integrated contextually-based open system');
INSERT INTO Review (id, reviews) VALUES (2, 'Cross-platform well-modulated initiative');
INSERT INTO Review (id, reviews) VALUES (3, 'Customizable attitude-oriented system engine');
INSERT INTO Review (id, reviews) VALUES (4, 'Persevering content-based capacity');
INSERT INTO Review (id, reviews) VALUES (5, 'Optional hybrid contingency');
INSERT INTO Review (id, reviews) VALUES (6, 'Right-sized leading edge capability');
INSERT INTO Review (id, reviews) VALUES (7, 'Business-focused stable initiative');
INSERT INTO Review (id, reviews) VALUES (8, 'Right-sized regional project');
INSERT INTO Review (id, reviews) VALUES (9, 'Face to face responsive encryption');
INSERT INTO Review (id, reviews) VALUES (10, 'Networked 3rd generation challenge');

--State
INSERT INTO AddressLocation (id, stateTerritory) VALUES (1, 'Abruglia');
INSERT INTO AddressLocation (id, stateTerritory) VALUES (2, 'Bourgogne');
INSERT INTO AddressLocation (id, stateTerritory) VALUES (3, 'Évora');



END;