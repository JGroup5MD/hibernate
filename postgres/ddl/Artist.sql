SELECT
MAX(artist),
COUNT(artist)

FROM public.vote
GROUP BY (artist)
order by Count desc