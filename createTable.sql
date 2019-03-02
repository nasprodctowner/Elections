drop table ELECTEUR;
CREATE TABLE ELECTEUR
   (
    numElecteur INTEGER(6)  NOT NULL AUTO_INCREMENT,
	nom VARCHAR(12) NULL,
	prenom VARCHAR(12) NULL,
	age INTEGER (6) NULL,
	categorie VARCHAR(12) NULL,
	aVote CHAR(1) NOT NULL,
    CONSTRAINT PK_ELECTEUR PRIMARY KEY (numElecteur)  
   ) ;

insert into ELECTEUR values (0, 'dupont', 'jean', 24, 'etudiant', 'N');
insert into ELECTEUR values (1, 'durant', 'jacques', 40, 'enseignant', 'N');

drop table LISTE;
CREATE TABLE LISTE
   (
    idListe INTEGER(6)  NOT NULL AUTO_INCREMENT,
    CONSTRAINT PK_LISTE PRIMARY KEY (idListe)  
   ) ;
   
insert into LISTE values (0);
insert into LISTE values (1);
insert into LISTE values (2);
insert into LISTE values (3);

drop table VOTE;
CREATE TABLE VOTE
   (
    id INTEGER(6)  NOT NULL AUTO_INCREMENT,
	age INTEGER(6) NULL,
	categorie VARCHAR(12) NULL,
    CONSTRAINT PK_VOTE PRIMARY KEY (id)  
   ) ;
   
drop table LISTE_VOTE;
CREATE TABLE LISTE_VOTE
	(
	LISTE_idListe INTEGER (6) NOT NULL,
	LESVOTES_id INTEGER (6) NOT NULL,
	CONSTRAINT PK_LISTE_VOTE PRIMARY KEY (LISTE_idListe, LESVOTES_id),
	CONSTRAINT FK_LV FOREIGN KEY (LISTE_idListe)
	  						REFERENCES LISTE (idListe), 
	 CONSTRAINT FK_VL FOREIGN KEY (LESVOTES_id)
	  REFERENCES VOTE (id) 
	);


