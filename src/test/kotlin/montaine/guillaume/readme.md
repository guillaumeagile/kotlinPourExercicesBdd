# Produit
Nous allons construire une caisse enregistreuse capable de nous sortir un ticket de caisse à partir d'un panier d'achat.

Le panier est composé de "lignes".

chaque ligne d'achat est composé de:

   - un libellé de produit
   - une quantité de produit
   - un prix unitaire de produit Hors Taxes

La caisse accepte 2 entrées : 
- un panier
- les 2 lettres d’un code d’état américain

Avec les 2 lettres du code d’un état américain, nous seront capable de calculer la TVA en fonction de l'état

Avec le prix total hors taxe nous sommes capable de calculer une réduction, voir le tableau ci dessous.

Le ticket de caisse devrait ressembler à :

 ```
                       Quantité   Prix unitaire  Prix total
Bracelet de remplacement      2            7.30       14.60
Chargeur                      1           29.99       29.99
-----------------------------------------------------------
Total HT                                              XXXXX
Réduction X%                                           -YYY
TVA Y%                                                 +ZZZ
-----------------------------------------------------------
Total TTC                                            XXXXXX
 ```

le tableau de calcul des réductions est le suivant :

 ```
Total HT	Réduction
> 1000	    3%
> 5000	    5%
> 7000	    7%
> 10000	    10%
> 50000	    15%

État	Taux de TVA
UT	    6.85%
NV	    8.00%
TX	    6.25%
AL	    4.00%
CA	    8.25%
 ```