# Vote-Group5-Hibernate

<<<<<<< HEAD
/Jenres
=======
#/Jenres
>>>>>>> 6be1f25d7192dc2acda53b371bba79f040fc2927
To get a list of genres:

(GET)http://host:port/WarFileName/genres
To create, update or delete genre use respective POST queries:

(POST)http://host:port/WarFileName/genres?create=(genre_name)
(POST)http://host:port/WarFileName/genres?update=(genre_id)&name=(new_genre_name)
(POST)http://host:port/WarFileName/genres?delete=(genre_id)

<<<<<<< HEAD
/Singers
=======
#/Singers
>>>>>>> 6be1f25d7192dc2acda53b371bba79f040fc2927
To get a list of performers:

(GET)http://host:port/WarFileName/performers
To create, update or delete performers use respective POST queries:

(POST)http://host:port/WarFileName/performers?create=(performer_name)
(POST)http://host:port/WarFileName/performers?update=(performer_id)&name=(new_performer_name)
(POST)http://host:port/WarFileName/performers?delete=(performer_id)


<<<<<<< HEAD
/vote (1 vote for performer, 3-5 votes for genre)
=======
#/vote (1 vote for performer, 3-5 votes for genre)
>>>>>>> 6be1f25d7192dc2acda53b371bba79f040fc2927
(POST)http://host:port/WarFileName/
vote?performer=(performer_id)&genre=(genre_id)&about=(about)&email=(email)


<<<<<<< HEAD
/vote_Result(typically redirected to)
=======
#/vote_Result(typically redirected to)
>>>>>>> 6be1f25d7192dc2acda53b371bba79f040fc2927
(GET)http://host:port/WarFileName/vote_result


