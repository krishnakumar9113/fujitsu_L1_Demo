--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

-- Started on 2020-12-18 02:40:17

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 16395)
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employees (
    emp_id bigint NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    gender character varying(2) NOT NULL,
    dob date NOT NULL,
    pan_num character varying(15),
    aadhaar_num character varying(15),
    permanent_address text,
    mobile_num character varying(15) NOT NULL,
    email_id character varying(150) NOT NULL,
    office_mail character varying(150) NOT NULL,
    present_address text,
    blood_group character varying(5),
    profile_pict character varying(200),
    doj date NOT NULL,
    emp_level bigint NOT NULL,
    post_name character varying(30) NOT NULL,
    basic_pay bigint NOT NULL,
    house_allowance bigint NOT NULL
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16403)
-- Name: employment_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employment_history (
    id bigint NOT NULL,
    emp_id bigint NOT NULL,
    from_date date NOT NULL,
    until_date date NOT NULL,
    location character varying(30) NOT NULL,
    country text,
    post character varying(30) NOT NULL,
    skill_used text,
    organization_name character varying NOT NULL
);


ALTER TABLE public.employment_history OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16416)
-- Name: id_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.id_sequence
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_sequence OWNER TO postgres;

--
-- TOC entry 2991 (class 0 OID 16395)
-- Dependencies: 200
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employees (emp_id, first_name, last_name, gender, dob, pan_num, aadhaar_num, permanent_address, mobile_num, email_id, office_mail, present_address, blood_group, profile_pict, doj, emp_level, post_name, basic_pay, house_allowance) FROM stdin;
1	adsf	df	hh	2000-12-31	asdf	56345	ths,dgh	2342342134	adfadf@dadsf	adfasd@adfad	asdfad,dfgs	o+ve	asdfadf	2000-12-31	1	asdfad	34234	231423
102	adsfsadf2102updated	df	hh	2000-12-31	asdf	56345	ths,dgh	2342342134	adfadf@dadsf	adfasd@adfad	asdfad,dfgs	o+ve	asdfadf	2000-12-31	1	asdfad	34234	231423
152	adsf	df	hh	2000-12-31	asdf	56345	ths,dgh	2342342134	adfadf@dadsf	adfasd@adfad	asdfad,dfgs	o+ve	asdfadf	2000-12-31	1	asdfad	34234	231423
\.


--
-- TOC entry 2992 (class 0 OID 16403)
-- Dependencies: 201
-- Data for Name: employment_history; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employment_history (id, emp_id, from_date, until_date, location, country, post, skill_used, organization_name) FROM stdin;
1	1	2020-01-21	2020-02-21	chennai	India	ProjectManager	java	ABC pvt ltd
252	1	2020-01-21	2020-02-21	chennai	India	ProjectManager	java	AB2C pvt ltd
\.


--
-- TOC entry 2999 (class 0 OID 0)
-- Dependencies: 202
-- Name: id_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.id_sequence', 351, true);


--
-- TOC entry 2857 (class 2606 OID 16399)
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (emp_id);


--
-- TOC entry 2859 (class 2606 OID 16410)
-- Name: employment_history employment_history_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employment_history
    ADD CONSTRAINT employment_history_pkey PRIMARY KEY (id);


--
-- TOC entry 2860 (class 2606 OID 16418)
-- Name: employment_history emp_id_fk_del_cs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employment_history
    ADD CONSTRAINT emp_id_fk_del_cs FOREIGN KEY (emp_id) REFERENCES public.employees(emp_id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


-- Completed on 2020-12-18 02:40:25

--
-- PostgreSQL database dump complete
--

