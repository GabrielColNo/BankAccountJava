**Projet de Système Bancaire en Java**

Une application console simple pour simuler les opérations de base d'un système bancaire. Ce projet a été conçu pour mettre en pratique les concepts fondamentaux de la Programmation Orientée Objet (POO).

**Table des matières**

- Fonctionnalités
- Structure du Projet
- Installation et Exécution

**Fonctionnalités**

- `Gestion des comptes` : Permet de créer des comptes courants ou des comptes épargne pour de nouveaux clients.
- `Opérations bancaires` : Offre la possibilité d'effectuer des dépôts et des retraits sur les comptes existants.
- `Consultation de solde` : Affiche le solde d'un compte à tout moment.
- `Sécurité des opérations` : Utilise une exception personnalisée, SoldeInsuffisantException, pour empêcher les retraits qui dépasseraient le solde disponible, assurant ainsi la robustesse du programme.
- `Fonctionnalité Bonus` (Compte Épargne) : Inclut une classe CompteEpargne qui hérite de CompteBancaire et ajoute une méthode pour calculer et ajouter des intérêts annuels.
- `Fonctionnalité Bonus` (Historique) : Enregistre toutes les transactions (dépôts et retraits) dans un fichier texte nommé historique.txt.

**Structure du Projet**

Le code source est organisé de manière modulaire. Chaque fichier .java a une responsabilité unique :
- `Client.java` : Modélise un client de la banque avec des informations de base comme le nom et l'adresse.
- `CompteBancaire.java` : Représente la classe de base pour un compte bancaire. Elle contient la logique pour les opérations de dépôt, de retrait et de consultation.
- `CompteEpargne.java` : Classe dérivée qui spécialise CompteBancaire. Elle y ajoute la notion de taux d'intérêt.
- `SoldeInsuffisantException.jav` : Définit l'exception personnalisée qui est levée lorsqu'un retrait ne peut être effectué.
- `GestionBancaire.java` : Classe principale contenant la méthode main. Elle gère l'interface utilisateur en mode console et orchestre les interactions entre les différents objets.

**Installation et Exécution**

- Ce projet ne requiert aucune dépendance externe. Seul un JDK (Java Development Kit) est nécessaire pour la compilation et l'exécution.

**1. Prérequis**

Assurez-vous que Java est installé sur votre système et que les commandes javac et java sont accessibles depuis votre terminal.

**2. Compilation**

Ouvrez un terminal, naviguez jusqu'au répertoire contenant les fichiers sources et exécutez la commande suivante pour compiler tous les fichiers .java :

`javac *.java`


**3. Exécution**

Une fois la compilation terminée sans erreur, lancez le programme avec la commande :

`java GestionBancaire`


Le menu interactif de l'application s'affichera alors dans la console.
