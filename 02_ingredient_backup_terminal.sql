--
-- PostgreSQL database dump
--

-- Dumped from database version 15.9 (Homebrew)
-- Dumped by pg_dump version 15.10 (Homebrew)

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
-- Name: ingredient; Type: TABLE; Schema: public; Owner: divya
--

CREATE TABLE public.ingredient (
    ingredient_id integer NOT NULL,
    name character varying(200) NOT NULL,
    quantity character varying(250),
    unit character varying(50),
    fridge_staple integer
);


ALTER TABLE public.ingredient OWNER TO divya;

--
-- Name: ingredient_ingredient_id_seq; Type: SEQUENCE; Schema: public; Owner: divya
--

CREATE SEQUENCE public.ingredient_ingredient_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ingredient_ingredient_id_seq OWNER TO divya;

--
-- Name: ingredient_ingredient_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: divya
--

ALTER SEQUENCE public.ingredient_ingredient_id_seq OWNED BY public.ingredient.ingredient_id;


--
-- Name: ingredient ingredient_id; Type: DEFAULT; Schema: public; Owner: divya
--

ALTER TABLE ONLY public.ingredient ALTER COLUMN ingredient_id SET DEFAULT nextval('public.ingredient_ingredient_id_seq'::regclass);


--
-- Data for Name: ingredient; Type: TABLE DATA; Schema: public; Owner: divya
--

COPY public.ingredient (ingredient_id, name, quantity, unit, fridge_staple) FROM stdin;
1	Fresh mince	500	g	0
2	Dried spagetti	400	g	1
3	Smoked streaky bacon, finely diced	4	Rashers	0
4	Plum tomatoes	2	tins	0
5	Cherry tomatoes	6		0
6	Onions	2		1
7	Celery	2	Sticks	0
8	Carrots	2		0
9	Garlic	2	Cloves	1
10	Chilli	1		0
11	Parmesan Cheese	75	g	0
12	Tomato Puree	2	tbsp	1
13	Stock cube	1		0
14	Red wine	1	glasses	0
15	Rosemary	2-3	Sprigs	0
16	Dried Oregano	1	tsp	1
17	Fresh Bay Leaves	1-2		1
18	Olive oil			1
19	Salt			1
20	Black pepper			1
21	Crusty Bread			0
22	Chilli Flakes	0.25	tsp	1
23	Tomato puree	100	g	1
24	Vodka	5	tbsp	0
25	Double Cream	100	ml	0
26	Pasta	200	g	1
27	Parmesan	30	g	0
28	Basil	2	leaves	0
29	Onion	1		1
30	Chilli Flakes	0.25	tsp	1
31	Chopped tomatoes	2	tins	0
32	Sugar	1	tsp	1
33	Cheese	90	g	0
34	Chicken	4	pieces	0
35	Pasta	200	g	1
36	Mozzarella	50	g	1
37	Cheddar	50	g	1
38	Parsley	10	g	1
39	Rice	250	g	1
40	Vegetable oil	3	tbsp	1
41	Onion	1		1
42	Eggs	4		1
43	Spring onions	2		1
44	Eggs	2		1
45	Cream	6	tbsp	1
46	Butter	1	tbsp	1
47	Chicken	1	pack	1
48	Lemons	6		0
49	Rosemary	4	sprigs	0
50	Onion	2		1
51	Garlic	9	cloves	1
52	Thyme	1	tbsp	0
53	Potatoes	500	g	0
54	Lemon thyme	3	sprigs	0
55	Pasta	300	g	1
56	Butter	20	g	1
57	Garlic	6	cloves	1
58	Flour	2	tbsp	1
59	Chicken Stock	150	ml	0
60	Double cream	200	ml	0
61	Parmesan	85	g	0
62	Parsley	20	g	0
63	Egg	2		1
64	Butter	1	tbsp	1
65	Cheddar	15	g	0
66	Tomatoes	4		0
67	Cucumber	1		0
68	Red Onion	0.5		1
69	Olives	16		0
70	Oregano	1	tsp	0
71	Feta	85	g	0
72	Olive oil	4	tbsp	1
73	Aubergine	1		0
74	Olive oil	1	tbsp	1
75	Vinegar	0.5	tbsp	1
76	Yogurt	2	tbsp	0
77	Tahini	1	tbsp	0
78	Garlic	1	clove	1
79	Cumin	1.5	tsp	1
80	Coriander	0.5	tsp	1
81	Paprika	1	tsp	1
82	Chicken	2	Breasts	0
83	Vegetable Oil	1	tbsp	1
84	Tortilla wrap	4		0
85	Tomatoes	4		0
86	Avocado	1		0
87	Tortilla	2		0
88	Kidney beans	1	can	0
89	Spring onion	1		0
90	Chicken	50	g	0
91	Cheddar	85	g	1
92	Coriander	10	g	0
\.


--
-- Name: ingredient_ingredient_id_seq; Type: SEQUENCE SET; Schema: public; Owner: divya
--

SELECT pg_catalog.setval('public.ingredient_ingredient_id_seq', 92, true);


--
-- Name: ingredient ingredient_pkey; Type: CONSTRAINT; Schema: public; Owner: divya
--

ALTER TABLE ONLY public.ingredient
    ADD CONSTRAINT ingredient_pkey PRIMARY KEY (ingredient_id);


--
-- PostgreSQL database dump complete
--

