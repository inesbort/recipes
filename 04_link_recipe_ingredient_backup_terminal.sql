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
-- Name: link_recipe_ingredient; Type: TABLE; Schema: public; Owner: divya
--

CREATE TABLE public.link_recipe_ingredient (
    recipe_id integer,
    ingredient_id integer
);


ALTER TABLE public.link_recipe_ingredient OWNER TO divya;

--
-- Data for Name: link_recipe_ingredient; Type: TABLE DATA; Schema: public; Owner: divya
--

COPY public.link_recipe_ingredient (recipe_id, ingredient_id) FROM stdin;
1	1
1	2
1	3
1	4
1	5
1	6
1	7
1	8
1	9
1	10
1	11
1	12
1	13
1	14
1	15
1	16
1	17
1	18
1	19
1	20
1	21
2	9
2	18
2	6
2	22
2	23
2	24
2	25
2	26
2	27
2	28
3	18
3	9
3	6
3	30
3	31
3	32
3	33
3	34
3	35
3	36
3	37
3	38
4	39
4	40
4	41
4	42
4	43
5	44
5	45
5	46
6	47
6	48
6	49
6	50
6	51
6	52
6	53
6	54
6	18
7	55
7	56
7	57
7	58
7	59
7	60
7	61
7	62
8	18
8	63
8	64
8	65
9	66
9	67
9	68
9	69
9	70
9	71
9	72
10	68
10	73
10	74
10	75
10	76
10	77
10	78
10	79
10	80
10	81
10	82
10	83
10	84
10	85
10	86
11	87
11	88
11	89
11	90
11	91
11	92
\.


--
-- Name: link_recipe_ingredient link_recipe_ingredient_ingredient_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: divya
--

ALTER TABLE ONLY public.link_recipe_ingredient
    ADD CONSTRAINT link_recipe_ingredient_ingredient_id_fkey FOREIGN KEY (ingredient_id) REFERENCES public.ingredient(ingredient_id);


--
-- Name: link_recipe_ingredient link_recipe_ingredient_recipe_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: divya
--

ALTER TABLE ONLY public.link_recipe_ingredient
    ADD CONSTRAINT link_recipe_ingredient_recipe_id_fkey FOREIGN KEY (recipe_id) REFERENCES public.recipe(recipe_id);


--
-- PostgreSQL database dump complete
--

