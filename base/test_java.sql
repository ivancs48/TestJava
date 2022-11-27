--
-- PostgreSQL database dump
--

-- Dumped from database version 14.4
-- Dumped by pg_dump version 14.4

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
-- Name: clientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clientes (
    id_cliente integer NOT NULL,
    nombre character varying NOT NULL,
    apellido character varying,
    direccion character varying,
    email character varying,
    celular character varying
);


ALTER TABLE public.clientes OWNER TO postgres;

--
-- Name: COLUMN clientes.id_cliente; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.clientes.id_cliente IS 'id tabla clientes';


--
-- Name: COLUMN clientes.nombre; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.clientes.nombre IS 'nombre cliente';


--
-- Name: COLUMN clientes.apellido; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.clientes.apellido IS 'apellido cliente';


--
-- Name: COLUMN clientes.direccion; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.clientes.direccion IS 'direccion cliente';


--
-- Name: COLUMN clientes.email; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.clientes.email IS 'email cliente';


--
-- Name: COLUMN clientes.celular; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.clientes.celular IS 'celular cliente';


--
-- Name: clientes_id_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clientes_id_cliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clientes_id_cliente_seq OWNER TO postgres;

--
-- Name: clientes_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.clientes_id_cliente_seq OWNED BY public.clientes.id_cliente;


--
-- Name: clientes id_cliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes ALTER COLUMN id_cliente SET DEFAULT nextval('public.clientes_id_cliente_seq'::regclass);


--
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clientes (id_cliente, nombre, apellido, direccion, email, celular) FROM stdin;
1	test	java	calle	correo	123
5	diana	f	call	correo	456
2	ivan	c	carrera	correo	123
6	stefanini	chaoter	calle 122	correo	789
\.


--
-- Name: clientes_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clientes_id_cliente_seq', 6, true);


--
-- Name: clientes clientes_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pk PRIMARY KEY (id_cliente);


--
-- PostgreSQL database dump complete
--

