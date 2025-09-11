# Spécifications BDD - Système de Facturation

## Épic 2: Création de factures

User goal = créer une facture

### Feature 2.1: Créer une facture

**En tant que** artisan du système de facturation
**Je veux** créer une facture avec un montant valide
**Afin de** documenter les transactions commerciales

#### Exemples de scénarios:

1. Création d'une facture avec un montant positif en tant que artisan
1. Tentative de Création d'une facture avec un montant positif en tant que administrateur doit echouer
2. Création d'une facture avec un montant nul
3. Tentative de création d'une facture avec un montant négatif

##### scenario 1

Given: je suis un artisan
When: je crée une facture avec un montant positif
Then: la facture est créée avec succès

Question: comment je sais que je suis un artisan ?

##### scenario 2

Given: je suis un administrateur
When: je crée une facture avec un montant positif
Then: la facture n'est pas crée avec motif "seul un artisan peut créer une facture"

#### Exemples de scénarios:

1. Validation du format du numéro de facture
2. Validation de la date de facture
3. Validation du client associé à la facture

## Épic 3: Gestion des factures

### Feature 2.1: Consulter une facture

**En tant que** utilisateur du système de facturation
**Je veux** consulter les détails d'une facture existante
**Afin de** vérifier les informations de facturation

#### Exemples de scénarios:

1. Consultation d'une facture existante par son numéro
2. Tentative de consultation d'une facture inexistante

### Feature 2.2: Liste des factures

**En tant que** utilisateur du système de facturation
**Je veux** voir la liste des factures
**Afin de** gérer l'ensemble des factures du système

#### Exemples de scénarios:

1. Affichage de la liste complète des factures
2. Filtrage des factures par date
3. Tri des factures par montant

# Example Mapping

### Règle 1: Validation du montant de facture

**Question**: Qu'arrive-t-il si on tente de créer une facture avec un montant négatif ?
**Réponse**: Le système doit retourner une erreur indiquant que le montant doit être positif ou nul.

**Exemples**:

- Montant = -100€ → Échec
- Montant = 0€ → Succès
- Montant = 100€ → Succès

**Mots clés**: montant, négatif, validation

### Règle 2: Format du numéro de facture

**Question**: Quel est le format attendu pour le numéro de facture ?
**Réponse**: Le numéro de facture doit suivre le format "FACT-YYYY-MM-NNNN" où YYYY est l'année, MM le mois et NNNN un
numéro séquentiel.

**Exemples**:

- FACT-2023-09-0001 → Succès
- FACT-23-09-0001 → Échec (année incomplète)
- F-2023-09-0001 → Échec (préfixe incorrect)

**Mots clés**: numéro, format, validation

### Règle 3: Date de facture

**Question**: Peut-on créer une facture avec une date future ?
**Réponse**: Oui, une facture peut avoir une date future (facture d'acompte).

**Exemples**:

- Date = aujourd'hui → Succès
- Date = dans 30 jours → Succès
- Date = il y a 30 jours → Succès

**Mots clés**: date, future, passée