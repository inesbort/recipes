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
-- Name: recipe; Type: TABLE; Schema: public; Owner: divya
--

CREATE TABLE public.recipe (
    recipe_id integer NOT NULL,
    recipe_name character varying(255) NOT NULL,
    recipe_description text,
    prep_time character varying(255),
    cook_time character varying(255),
    img character varying(255)
);


ALTER TABLE public.recipe OWNER TO divya;

--
-- Name: recipe_recipe_id_seq; Type: SEQUENCE; Schema: public; Owner: divya
--

CREATE SEQUENCE public.recipe_recipe_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.recipe_recipe_id_seq OWNER TO divya;

--
-- Name: recipe_recipe_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: divya
--

ALTER SEQUENCE public.recipe_recipe_id_seq OWNED BY public.recipe.recipe_id;


--
-- Name: recipe recipe_id; Type: DEFAULT; Schema: public; Owner: divya
--

ALTER TABLE ONLY public.recipe ALTER COLUMN recipe_id SET DEFAULT nextval('public.recipe_recipe_id_seq'::regclass);


--
-- Data for Name: recipe; Type: TABLE DATA; Schema: public; Owner: divya
--

COPY public.recipe (recipe_id, recipe_name, recipe_description, prep_time, cook_time, img) FROM stdin;
1	Spaghetti Bolognese	My very best Spaghetti Bolognese, gorgeously meaty with a chilli kick!	25 minutes	1 hour 15 minutes	\N
2	Pasta alla vodka	Sit back and tuck into a big bowl of pasta alla vodka, a creamy tomato pasta with – as you can guess – vodka, which balances out the intense flavours	5 minutes	25 minutes	\N
3	Chicken pasta bake	Enjoy this gooey cheese and chicken pasta bake for the ultimate weekday family dinner. Serve straight from the dish with a dressed green salad	30 minutes	45 minutes	\N
4	Egg-fried rice	Make your own healthy egg-fried rice with our easy recipe. Use leftover rice, or cook and dry it on a plate before using so it does not stick to the wok. Make it your own by adding whatever leftover veggies you have in the fridge	10 minutes	10 minutes	\N
5	Scrambled eggs	Learn how to make scrambled eggs in a pan with this easy, foolproof recipe. This speedy breakfast is packed with protein and takes just 10 minutes. Serve with rice, bread or on its own.	5 minutes	5 minutes	\N
6	One-pan roast chicken & potatoes	Bring the pan straight to the table and use the juices to make a light, lemony gravy for the perfect roast	15 minutes	See chicken packet for cooking times	\N
7	Creamy garlic pasta	This creamy tagliatelle recipe makes a comforting midweek meal. Any long pasta will work, so use whatever you have in the cupboard	5 minutes	20 minutes	\N
8	Cheese omelette	Rustle up a simple omelette for a quick and easy snack any time of day. Use mature cheddar for maximum cheesy flavour. Serve on its own, with rice or with baked potatoes	5 minutes	5 minutes	\N
9	Greek salad	Make a fresh and colourful Greek salad in no time. It is great with grilled meats at a barbecue, or on its own as a veggie main	15 minutes	No cook time	\N
10	Chicken wraps	Pile chicken, charred aubergine, tomatoes, red onion and avocado into a tortilla to make these quick and easy wraps. Full of veg, they are a perfect quick food. Feel free to customise with your own veggies and sauces!	12 minutes	20 minutes	\N
11	Chicken quesadilla	These easy, budget-friendly chicken quesadillas make a quick lunch for two or a simple party snack and are a great way to use up leftover roast chicken	10 minutes	6 minutes	\N
\.


--
-- Name: recipe_recipe_id_seq; Type: SEQUENCE SET; Schema: public; Owner: divya
--

SELECT pg_catalog.setval('public.recipe_recipe_id_seq', 11, true);


--
-- Name: recipe recipe_pkey; Type: CONSTRAINT; Schema: public; Owner: divya
--

ALTER TABLE ONLY public.recipe
    ADD CONSTRAINT recipe_pkey PRIMARY KEY (recipe_id);


--
-- PostgreSQL database dump complete
--

