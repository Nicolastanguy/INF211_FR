/*


num_secteuractivite integer NOT NULL,
  num_candidature integer NOT NULL,

   num_candidature INTEGER NOT NULL PRIMARY KEY,
    nom VARCHAR(45) NOT NULL,
    prenom VARCHAR(45) NOT NULL,
    dateNaissance DATE,
    adressePostale VARCHAR(100),
    adresseEmail VARCHAR(45),
    dateDepot DATE,
    num_niveauQualification INTEGER NOT NULL,
*/


INSERT INTO niveauqualification VALUES('2','ENSEIG');
INSERT INTO offreemploi VALUES('2','Prof ELP110','Expliquer sans être chercheur','ENSEIG','16/03/14','2','2');
INSERT INTO secteurActivite values ('2','ENSEIG');
INSERT INTO offreemploi_secteuractivite VALUES ('2','2');
INSERT INTO candidature VALUES('2','BROSSARD','Thomas','28/04/1994','rue de rennes','tbrossard@icloud.com','14/03/2013','2');
INSERT INTO messageoffreemploi VALUES('2','12/04/14','Message test','2','2');
INSERT INTO secteuractivite_candidature values('2','2');
INSERT INTO messagecandidature VALUES('2','28/05/2014','Ceci est un message de test2','2','2');
