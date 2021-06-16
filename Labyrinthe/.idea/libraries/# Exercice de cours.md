# Exercice de cours 

Soit un skieur caractérisé par son nom, un pays et un nombre de points. Chaqueskieur est membre d’une équipe. Une équipe est caractérisée par un nom et unsiège social. Toutes les propriétés sont privées. Il sera possible de consulter lavaleur de chaque propriété et modifier le nombre de points d’un skieur.

@startuml
hide empty member
left to right direction

class Skieur{
    - nom : string
    - pays : string
    - nbPoints : number
    + getNom() : string
    + getPays() : string
    + getNbPoints(): number
}

class Equipe{
    - nomEquipe: string
    - siegeSocial: string
    + getNomEquipe(): string
    + getSiegeSocial(): string

}

Skieur "*" -- "1" Equipe : participe >
@enduml


Soit un article caractérisé par son nom, son rayon(la liste des rayons est fixe) etson prix. Un article peut être stocké dans plusieurs entrepôts. Un entrepôt estcaractérisé par un nom, une ville. Les caractéristiques des articles et des entrepôtssont privées. Il sera possible de consulter la valeur de chaque propriété. De plus ilsera possible d’appliquer un pourcentage de réduction et/ou d’augmentation surchaque article.

@startuml

class Article{
    - nomArticle : string
    - rayon : string
    - prixArticle : number

}

class Entrepot{
    - nomEntrepot : 
}
@enduml