# kata

## Introduction 
Le code fourni dans ce projet permet de générer une chaîne de caractères basée sur deux critères : la divisibilité par certains nombres (3, 5 et 7) et la présence de chiffres spécifiques dans une chaîne de caractères donnée (3, 5, 7 et 0).

#### Étape 1 : Vérifier la divisibilité par 3, 5 et 7
- Si le nombre est divisible par 3, on ajoute "Foo".
- Si le nombre est divisible par 5, on ajoute "Bar".
- Si le nombre est divisible par 7, on ajoute "Qix".

##### Exemple de 15
Par exemple, pour 15 : il est divisible par 3 et par 5, donc on affiche FooBar.

#### Étape 1 (suite) : Pour chaque chiffre du nombre
Ensuite, on vérifie chaque chiffre dans le nombre pour voir s'il contient 3, 5, ou 7.

- Si le chiffre est 3, on ajoute "Foo".
- Si le chiffre est 5, on ajoute "Bar".
- Si le chiffre est 7, on ajoute "Qix".

##### Exemple de 53 :

Prenons 53, ce chiffre n'est pas divisible par 3, mais pour le chiffre 5 on ajoute "Bar", et pour le chiffre 3 ajoute "Foo". La sortie sera donc BarFoo.

#### Étape 2 : Remplacer les zéros par des étoiles
Dans la nouvelle règle de l'étape 2, on doit garder une trace des 0 en les remplaçant par le caractère '*'. Pour ce faire, dans la boucle qui parcourt chaque chiffre, dès qu'on trouve un 0, on ajoute une étoile '*'.

##### Exemple
Pour le chiffre 101 :
- On garde le chiffre 1 tel quel.
- On remplace le 0 par '*'.
- On garde le dernier 1. La sortie devient donc 1*1.

## Explication du code
### structure 
- On a une classe java appelée FooBarQix contenant une méthode principale compute qui prend une chaîne de caractères comme entrée et retourne un résultat basé sur les règles décrites.
Deux méthodes auxiliaires sont utilisées :
- checkDivisibility: vérifie si le nombre est divisible par 3, 5 ou 7.
- verifyOccurences: vérifie la présence des chiffres 3, 5, 7 et 0 dans la chaîne.

###  Méthode compute

```java
public static String compute(String input) {
        StringBuilder result = new StringBuilder();
        int number = Integer.parseInt(input);

        // Check divisibility
        checkDivisibility(number, result);

        // Check occurences of 3/5/7 and handling 0
        verifyOccurences(input, result);
		
	// If nothing was appended in result, return the input with * for 0
        return result.length() > 0 ? result.toString() : input.replace('0', '*');

}
```
Cette méthode principale effectue trois opérations :

- Elle initialise un StringBuilder pour stocker le résultat.
- Elle convertit la chaîne de caractères d'entrée en un entier.
Elle appelle deux méthodes :
- checkDivisibility pour vérifier la divisibilité du nombre par 3, 5 ou 7.
- verifyOccurences pour vérifier la présence des chiffres 3, 5, 7 ou 0 dans l'entrée.
- Si le résultat n'est pas vide (si au moins une des règles a été satisfaite), elle renvoie le résultat. Sinon, elle renvoie l'entrée originale, mais en remplaçant les zéros par des *.

###  Méthode checkDivisibility

```java
private static void checkDivisibility(int number, StringBuilder result) {
        Map<Integer, String> multiplesMap = new HashMap<>();
        multiplesMap.put(3, "Foo");
        multiplesMap.put(5, "Bar");
        multiplesMap.put(7, "Qix");

        for (Map.Entry<Integer, String> entry : multiplesMap.entrySet()) {
            if (number % entry.getKey() == 0) {
                result.append(entry.getValue());
            }
        }
}
```

Cette méthode :

- Crée un HashMap (une sorte de dictionnaire) associant les nombres 3, 5 et 7 à leurs chaînes correspondantes ("Foo", "Bar" et "Qix").
- Vérifie si l'entier number est divisible par ces nombres. Si c'est le cas, la chaîne correspondante est ajoutée à result.
   > Par exemple, si number est divisible par 3, "Foo" est ajouté.

### Méthode verifyOccurences

```java
private static void verifyOccurences(String input, StringBuilder result) {
    for (char digit : input.toCharArray()) {
        switch (digit) {
            case '3':
                result.append("Foo");
                break;
            case '5':
                result.append("Bar");
                break;
            case '7':
                result.append("Qix");
                break;
            case '0':
                result.append("*");
                break;
            default:
                break;
        }
    }
}
```
Cette méthode :

- Parcourt chaque chiffre de la chaîne d'entrée.
- Si le chiffre est 3, 5 ou 7, elle ajoute "Foo", "Bar" ou "Qix" respectivement à result.
- Si le chiffre est 0, elle ajoute un * à la chaîne.
- Les autres chiffres sont ignorés.


## Test unitaires 
Une classe de test a été ajoutée pour s'assurer de la robustesse du code. Ajoutez JUnit 4 à votre projet : Si vous utilisez Maven, ajoutez cette dépendance à votre pom.xml
```java
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```
Pour lancer les test : 
```java
mvn test
```

## Conclusion
Ce code applique les règles suivantes à une chaîne numérique :

- Si le nombre est divisible par 3, 5 ou 7, il ajoute respectivement "Foo", "Bar" ou "Qix" au résultat.
- Si les chiffres 3, 5, 7 apparaissent dans l'entrée, il ajoute aussi "Foo", "Bar", "Qix" pour chaque occurrence.
- Les 0 sont remplacés par *.
- Si aucune de ces règles n'est satisfaite, l'entrée est renvoyée avec les 0 remplacés par *.

Ainsi, ce code suit les règles de divisibilité et de transformation des chiffres (3, 5, 7 et 0) telles que définies.