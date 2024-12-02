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
-- Name: instructions; Type: TABLE; Schema: public; Owner: divya
--

CREATE TABLE public.instructions (
    instruction_id integer NOT NULL,
    recipe_id integer,
    step_number integer NOT NULL,
    instruction text NOT NULL
);


ALTER TABLE public.instructions OWNER TO divya;

--
-- Name: instructions_instruction_id_seq; Type: SEQUENCE; Schema: public; Owner: divya
--

CREATE SEQUENCE public.instructions_instruction_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.instructions_instruction_id_seq OWNER TO divya;

--
-- Name: instructions_instruction_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: divya
--

ALTER SEQUENCE public.instructions_instruction_id_seq OWNED BY public.instructions.instruction_id;


--
-- Name: instructions instruction_id; Type: DEFAULT; Schema: public; Owner: divya
--

ALTER TABLE ONLY public.instructions ALTER COLUMN instruction_id SET DEFAULT nextval('public.instructions_instruction_id_seq'::regclass);


--
-- Data for Name: instructions; Type: TABLE DATA; Schema: public; Owner: divya
--

COPY public.instructions (instruction_id, recipe_id, step_number, instruction) FROM stdin;
1	1	1	Get yourself a large heavy-bottomed saucepan, and place it on a medium heat. Add a good lug of olive oil and gently fry your bacon until golden and crisp, then reduce the heat slightly and add your onions, carrots, celery and garlic. Next remove the leaves from the Rosemary sprigs and add them to the pot, discarding the sprigs. Move everything around and fry for around 8-10 minutes until the veg has softened.
2	1	2	Next, increase the heat slightly, add the mince and stir until the meat is browned all over
3	1	3	Stir in your tins of plum/chopped tomatoes, (plum tomatoes are best as they contain less water, but either will turn out great!). Add your remaining herbs, tomato puree, stock cube, chilli and if using, the wine. Slice your cherry tomatoes in half and throw them in aswell.
4	1	4	Give everything a stir with a wooden spoon, breaking up the plum tomatoes as you go and bring to a gentle simmer. Reduce the heat to low-medium, put the lid on and leave it blipping away for about an hour and 15 minutes until the flavours develop into a wonderfully rich tomatoey sauce. Stir occasionally to make sure it does not catch
5	1	5	Just as the sauce is nearly ready, Add the parmesan and season to taste. Meanwhile add salt to a pan of boiling water and cook the spaghetti according the the packet instructions. Once the spaghetti is ready, drain it in a colander and add it to the pan with the sauce. Give it all a good stir, coating the pasta in the lovely tomato sauce. Serve with a little grated parmesan and use the extra basil leaves to make a great little garnish. Beautiful!
7	2	2	Cook the pasta in salted water following pack instructions. Drain and reserve 150ml cooking water. Add roughly 50ml of the water to the tomato sauce, then tip in the pasta and cheese, tossing everything together over a low heat until well coated and glossy (loosen with a splash more of the cooking water if it is a little dry). Season to taste, then serve with a sprinkling of the extra parmesan, a good grinding of black pepper and the basil leaves scattered over the top.
8	3	1	Heat 2 tbsp of the oil in a pan over a medium heat and fry the onion gently for 10-12 mins. Add the garlic and chilli flakes and cook for 1 min. Tip in the tomatoes and sugar and season to taste. Simmer uncovered for 20 mins or until thickened, then stir through the cheese.
9	3	2	Heat 1 tbsp of oil in a non-stick frying pan. Season the chicken and fry for 5-7 mins or until the chicken is cooked through.
10	3	3	Heat the oven to 220C/200C fan/gas 7. Cook the penne following pack instructions. Drain and toss with the remaining oil. Tip the pasta into a medium sized ovenproof dish. Stir in the chicken and pour over the sauce. Top with the cheddar, mozzarella and parsley. Bake for 20 mins or until golden brown and bubbling.
11	4	1	Cook the rice following pack instructions, then drain, spread it out to steam-dry and set aside.
12	4	2	Heat 2 tbsp of the oil in a large wok over a high heat, then add the onion and fry until lightly browned, around 5 mins.
13	4	3	Add the rice, stir and toast for about 3 mins, then move to the side of the pan.
14	4	4	Add the remaining oil, then tip in the egg mixture.
15	4	5	Leave to cook a little, then mix in with the rice – stir vigorously to coat the grains or, if you prefer the egg chunkier, allow to set for a little longer before breaking up and stirring through.
16	4	6	Tip into a serving bowl and scatter over the spring onion to serve. You can also add sesame oil, ground white pepper and a splash of soy sauce to season.
17	5	1	Lightly whisk 2 large eggs, 6 tbsp single cream or full cream milk and a pinch of salt together until the mixture has just one consistency.
18	5	2	Heat a small non-stick frying pan for a minute or so, then add a knob of butter and let it melt. Do not allow the butter to brown or it will discolour the eggs.
19	5	3	Pour in the egg mixture and let it sit, without stirring, for 20 seconds. Stir with a wooden spoon, lifting and folding it over from the bottom of the pan.
20	5	4	Let it sit for another 10 seconds then stir and fold again.
21	5	5	Repeat until the eggs are softly set and slightly runny in places. Remove from the heat and leave for a moment to finish cooking.
22	5	6	Give a final stir and serve the velvety scramble without delay.
23	6	1	Heat oven to 190C/170C fan/gas 5. Stuff the chicken cavity with 2 lemon halves, 2 rosemary sprigs, 4 onion quarters and some seasoning. Put the chicken into a large roasting tray. If not using a whole chicken, put chicken parts in roasting tray and season, and then add lemon halves, rosemary springs and onion quarters to tray.
24	6	2	Crush 3 garlic cloves, then add to a small bowl with the thyme leaves and olive oil, mix, then rub this all over the chicken with some seasoning.
25	6	3	Arrange the potatoes around the chicken with the rest of the lemons and onions, rosemary and whole garlic cloves, and lemon thyme. Cook in the oven for 1 hr 20 mins -or however long according to chicken packet- turning the potatoes in the pan once or twice. To check if the chicken is cooked, pierce the thigh with a skewer and the juices should run clear.
26	6	4	Remove the chicken from the tray and place on a serving dish or board to rest for 15-20 mins. As you lift the chicken, let any juices pour back into the tray. Increase oven temperature to 200C/ 180C fan/gas 6 and cook the potatoes for a further 10-15 mins or until tender.
27	6	5	If you want gravy, use a slotted spoon to remove the potatoes from the tray to a serving bowl, then use a potato masher to mash all the juices, lemons, herbs and garlic together in the roasting tray, adding a splash of water if it is too pulpy. Push this mix through a sieve, taste the gravy and add some more seasoning if you need to.
28	7	1	Begin by cooking the pasta following pack instructions. Meanwhile, melt the butter in your largest frying pan. Once foaming, add the garlic and 25 twists of a black pepper mill. Cook for 4-5 mins, until the garlic is light golden and fragrant.
29	7	2	Stir in the flour to form a paste. Stir for 1-2 mins, then slowly whisk in the chicken stock until you have a smooth sauce. Pour in the double cream and sprinkle in most of the parmesan. Stir until everything is melted and combined, then season to taste.
30	7	3	Transfer the pasta straight into the sauce, alongside a good splash of the cooking water. Mix thoroughly, adding a little more pasta water if necessary, until you have a thick and glossy sauce.
31	7	4	Divide between four bowls and serve topped with the chopped parsley and remaining parmesan.
32	8	1	Crack the eggs into a jug and whisk well with a fork. Season with a pinch of salt.
33	8	2	Heat the oil and butter in a medium non-stick frying pan over a medium-low heat. Once the butter has started to foam, pour in the eggs and tilt to cover the base of the pan. Using a spatula, gently draw in the eggs from four points so there are folds in the centre. Do this once or twice, then leave the eggs to cook gently for 2-3 mins, until there is a little raw egg still in the middle. Sprinkle over the cheese and, using your spatula, gently fold the omelette in half. Switch off the heat and let the residual heat from the pan melt the cheese for 1 min. Slide onto your plate and sprinkle over some black pepper to serve.
35	9	2	Lightly season, then serve with crusty bread to mop up all of the juices.
36	10	1	Heat a dry griddle pan over a medium-high heat, and fry the aubergine rounds for 2 mins on each side until lightly coloured and char lines appear -you may need to do this in batches-  Transfer to a bowl with the onions, then toss with the olive oil and vinegar.
38	10	3	Warm the wraps in a dry frying pan, then fill with the tomatoes, aubergine and onion mix, avocado, chicken and tahini dressing.
39	11	1	Spread 2 tbsp salsa onto each tortilla, then evenly top one of them with the beans, spring onion, chicken and cheddar. Scatter with coriander, if you have it. Sandwich with the other tortilla, then brush with oil.
40	11	2	Heat a large non-stick frying pan, then cook the tortilla, oil-side down, for 4 mins. Carefully turn over with a palette knife -or by turning it out onto a plate, sliding it back into the pan-, then cook for 2 mins on the other side until golden. Serve cut into wedges.
41	2	1	Heat the oil in a large frying pan or casserole dish. Add the shallot and a large pinch of salt and gently fry over a low heat for 10 mins or until softened and translucent. Add the garlic and chilli flakes and cook for 30 seconds. Stir through the tomato puree, cook for 2 mins, then stir through the vodka and cook for 3 mins. Quickly stir through the cream to combine, then remove from the heat.
42	9	1	Place 4 large vine tomatoes, cut into wedges, 1 peeled, deseeded and chopped cucumber, half a thinly sliced red onion, 16 Kalamata olives, 1 tsp dried oregano, 85g feta cheese chunks and 4 tbsp Greek extra virgin olive oil in a large bowl
43	10	2	ombine the yogurt, tahini and garlic in a bowl with 1 tbsp water to loosen. Mix the cumin, coriander, paprika and some salt and pepper in a small bowl. Put the chicken on a board, cover with baking parchment and bash with a rolling pin to an even 1.5cm thickness. Rub all over with the spice mix, leave for 10 mins, then fry in the oil for 12 mins, flipping after 8 mins. Transfer to a board, rest briefly, then slice.
\.


--
-- Name: instructions_instruction_id_seq; Type: SEQUENCE SET; Schema: public; Owner: divya
--

SELECT pg_catalog.setval('public.instructions_instruction_id_seq', 43, true);


--
-- Name: instructions instructions_pkey; Type: CONSTRAINT; Schema: public; Owner: divya
--

ALTER TABLE ONLY public.instructions
    ADD CONSTRAINT instructions_pkey PRIMARY KEY (instruction_id);


--
-- Name: instructions instructions_recipe_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: divya
--

ALTER TABLE ONLY public.instructions
    ADD CONSTRAINT instructions_recipe_id_fkey FOREIGN KEY (recipe_id) REFERENCES public.recipe(recipe_id);


--
-- PostgreSQL database dump complete
--

