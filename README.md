# Vote-Group5-Hibernate

# /Jenres
_______________________________________________

(GET)http://host:port/WarFileName/genres
To create, update or delete genre use respective POST queries:

(POST)http://host:port/WarFileName/genres?create=(genre_name)
(POST)http://host:port/WarFileName/genres?update=(genre_id)&name=(new_genre_name)
(POST)http://host:port/WarFileName/genres?delete=(genre_id)


# /Singers
_______________________________________________

(GET)http://host:port/WarFileName/performers
To create, update or delete performers use respective POST queries:

(POST)http://host:port/WarFileName/performers?create=(performer_name)
(POST)http://host:port/WarFileName/performers?update=(performer_id)&name=(new_performer_name)
(POST)http://host:port/WarFileName/performers?delete=(performer_id)



# /vote (1 vote for performer, 3-5 votes for genre)
_______________________________________________
#/vote (1 vote for performer, 3-5 votes for genre)

(POST)http://host:port/WarFileName/
vote?performer=(performer_id)&genre=(genre_id)&about=(about)&email=(email)



# /vote_Result(typically redirected to)
_______________________________________________
#/vote_Result(typically redirected to)

(GET)http://host:port/WarFileName/vote_result


