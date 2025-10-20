#Projet Simple de Système Bancaire en Java

Ce projet est une application console simple qui simule les opérations de base d'un système bancaire. Il a été développé en Java et met en œuvre des concepts fondamentaux de la programmation orientée objet (POO), tels que les classes, l'héritage et la gestion des exceptions.

Fonctionnalités

Création de comptes : Permet de créer des comptes courants ou des comptes épargne pour de nouveaux clients.

Opérations de base : Dépôts et retraits sur les comptes existants.

Consultation : Affichage du solde d'un compte à tout moment.

Gestion des erreurs : Utilise une exception personnalisée (SoldeInsuffisantException) pour empêcher les retraits qui dépasseraient le solde disponible, assurant ainsi la robustesse du programme.

Comptes Épargne (Bonus) : Une classe CompteEpargne hérite de CompteBancaire et ajoute une fonctionnalité de calcul et d'ajout d'intérêts annuels.

Historique des transactions (Bonus) : Toutes les opérations (dépôts, retraits) sont enregistrées avec la date et l'heure dans un fichier historique.txt.

Structure du Projet

Le code source est réparti dans les fichiers suivants :

Client.java : Modélise un client avec son nom et son adresse.

CompteBancaire.java : Classe de base pour un compte bancaire, gérant les opérations principales.

CompteEpargne.java : Classe dérivée qui spécialise CompteBancaire avec un taux d'intérêt.

SoldeInsuffisantException.java : L'exception personnalisée pour la gestion des erreurs métier.

GestionBancaire.java : La classe principale avec la méthode main(), qui gère le menu interactif en console et la logique de l'application.

Comment Compiler et Exécuter

Ce projet ne nécessite aucune dépendance externe, seulement un JDK (Java Development Kit) installé.

Placez tous les fichiers .java dans le même répertoire.

Ouvrez un terminal ou une invite de commandes et naviguez jusqu'à ce répertoire.

Compilez tous les fichiers Java avec la commande suivante :

javac *.java


Exécutez le programme principal avec la commande :

java GestionBancaire


Le menu interactif s'affichera dans la console, vous guidant à travers les différentes options.
