# cryptage

Programme permettant de crypter ou décrypter une chaîne saisie en
fonction d’une clé saisie sur 8 caractères maximum.
Pour crypter la chaîne de caractères saisie, utiliser un tableau dans lequel sont affichés
autant d’alphabets qu'il y a de lettres (26) et qui crypte le texte à l’aide d’une clé de la
manière suivante :
 On cherche la valeur correspondant à la colonne i et la ligne j où i est la première
lettre du mot en clair et j la première lettre de la clé.
La lettre ainsi trouvée est la première lettre du mot crypté.
 On procède de même pour toutes les lettres du mot en clair.
 Lorsque la dernière lettre de la clé a été utilisée, on utilise de nouveau la première
et ainsi de suite.

exemple :
Texte en clair : INFORMATIQUE
Clé : INRACI
Cryptogramme : QAWOTUIGZQWM
Car ‘q’ est la lettre qui se trouve à l’intersection du ‘I’ horizontal du mot en clair et du ‘I’
vertical de la clé INRACI.
