# TP4-Le-probleme-de-la-sous-somme-avec-une-approche-recursive
TP4 : Le problème de la sous somme avec une approche récursive



U
 Définition du problème :
Etant donné un ensemble E de n entiers non négatifs, et une valeur S, il s’agit de déterminer s’il
existe un sous ensemble de E dont la somme des éléments est égale à S.
U
 Exemple :
E= {3, 6,2, 7, 9} ; S=9 ; les sous-ensembles {3,6}, {2,7} et {9} réalisent la solution. Si S=4
aucun sous ensemble ne réalise la solution.
Pour résoudre ce problème, on s’intéresse à une approche de type « diviser pour régner ». On
peut alors définir une fonction récursive qui retourne vrai s’il existe un sous ensemble de E dont
la somme des éléments est égale à S et retourne faux dans le cas contraire.
