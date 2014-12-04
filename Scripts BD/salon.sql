--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.9
-- Dumped by pg_dump version 9.2.9
-- Started on 2014-11-29 10:49:18

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 169 (class 1259 OID 16402)
-- Name: Salon; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Salon" (
    cod text NOT NULL,
    "Nombre_Local" text NOT NULL,
    "Descrip" text NOT NULL,
    "Costo" integer NOT NULL
);


ALTER TABLE public."Salon" OWNER TO sis2;

--
-- TOC entry 1920 (class 0 OID 16402)
-- Dependencies: 169
-- Data for Name: Salon; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Salon" (cod, "Nombre_Local", "Descrip", "Costo") FROM stdin;
\.


--
-- TOC entry 1813 (class 2606 OID 16409)
-- Name: Salon_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Salon"
    ADD CONSTRAINT "Salon_pkey" PRIMARY KEY (cod);


-- Completed on 2014-11-29 10:49:19

--
-- PostgreSQL database dump complete
--

