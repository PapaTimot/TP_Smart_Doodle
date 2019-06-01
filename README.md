# TP Smart Doodle


## Descripion du projet
 * Ce dépôt git contient tout le code correspondant à la partie backend du TP de MDI de l'ESIR.
Le but de ce TP étant de reproduire une application type doodle en utilisant hibernate, 
JPA côté serveur pour exposer une API REST permettant de manipuler les ressources,
et avec Vue.js côté client pour consommer l'API REST à travers une interface utilisateur.

## Architecture
 Les sources se divisent en quatres dossiers.
  * Dans le dossier `domain` on a définie quatres classes correspondants à quatres entities pouvant être persistées en base de donnée. 
  Un effort particulier à été fait sur la définition de ces classes avec ses attributs et ces liens, 
  notamment pour écrire les bonnes annotations permettant de décrire les relations entre entités.
  * Le dossier `jpa` contient les classes 'repository' qui offrent des méthodes pour requêter la base de donnée sur ces entités,
  comme `findById(id)` ou `save(entity)`.
  * Le dossier `exception` contient simplement les classes décrivants les exceptions lancées
  si une requête sur une ressource inexistante est reçue.
  * Et finalement le dossier `controller` définie les points d'entrées de l'API REST en mappant les requêtes CRUD à des méthodes java.
    
 ## Utilisation 
 * Par défaut, le projet est paramétré pour se connecter à une base de données local HSQL qu'il faut donc avoir lancé au préalable. Si vous lancez ce projet en étant connecté au réseau de l'ISTIC, vous pouvez modifier le fichier application.properties en commentant la partie `Config for local database` et en décommentant la partie `Config for database in ISTIC Server`. Ainsi vous pourrez exécuter le programme sans avoir à vous occuper d'abord de la BDD.
 * Le projet se lance ensuite en exécutant simplement la classe main dans `Application`, ou bien avec spring-boot (`spring-boot:run`). 
 Nous avons choisie d'utiliser le framework Spring car il facilite beaucoup le développement 
 en générant automatiquement du code qui aurait été long à écrire (comme toutes les méthodes des classes `repository` par exemple).
 
 
 
 ## Retrospective 
 * Nous avons mis assez longtemps à réussir à connecter la base de donnée au serveur de l'ISTIC,
 comprendre le fonctionnement de JPA et prendre en main Spring boot et Spring data. 
 Par conséquent la partie controller n'est pas tout à fait finie
 (il manque les méthodes REST pour manipuler les entités Préférences, User et User DatesChoice).
 Et la partie frontend n'est pas non plus très aboutie par manque de temps également. 
 
 * Néanmoins, ce TP nous aura bien profité car il nous aura fait expérimenter le développement fullstack d'une application web en java, 
 en passant par toutes les couches, de la base de donnée au placement des boutons sur l'interface utilisateur.


## Auteurs
 * Timothée Schneider-Maunoury
 * Yoann Breton
