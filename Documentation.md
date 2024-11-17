# Documentation du projet

## Java Swing

Java Swing fournit un ensemble riche de composants pour créer des interfaces utilisateur graphiques. 
Voici quelques-unes des interfaces et classes les plus couramment utilisées dans Java Swing


- JFrame : Fenêtre principale de l'application.
- JPanel : Conteneur pour organiser d'autres composants.
- `ImageIcon` charge et affiche des images dans les composants Swing.
- JButton : Bouton cliquable pour déclencher des actions.
- JLabel : Affiche du texte ou des images.
- JTextField : Champ de texte à une seule ligne.
- JTextArea : Zone de texte multi-lignes.
- JCheckBox : Case à cocher pour sélections binaires.
- JRadioButton : Bouton radio pour choix exclusifs.
- JComboBox : Liste déroulante pour sélectionner une option.
- JMenuBar/JMenu/JMenuItem : Composants pour créer des menus.
- JScrollPane : Conteneur avec barres de défilement.
- JTabbedPane : Conteneur avec onglets pour basculer entre panneaux.
- JToolBar : Barre d'outils pour accès rapide aux actions.

## java.awt
  Le package java.awt est aussiune bibliothèque utilisée pour créer des interfaces utilisateur graphiques (GUI). 
  Il fournit des composants de base pour construire des applications graphiques, bien que Swing soit souvent préféré 
  pour les applications modernes en raison de ses fonctionnalités plus avancées et de sa flexibilité.

Voici quelques-unes des classes et interfaces courantes que vous pouvez trouver dans java.awt :

Image: Représente une image graphique
Component : Classe de base pour tous les composants graphiques.
Container : Un composant qui peut contenir d'autres composants.
Button : Un bouton cliquable.
Label : Un composant pour afficher du texte.
TextField : Un champ de texte à une seule ligne.
TextArea : Une zone de texte multi-lignes.
Panel : Un conteneur générique pour organiser des composants.
Frame : Une fenêtre principale pour les applications.
Graphics : Classe pour dessiner des formes et du texte.
Color : Classe pour définir des couleurs.
Font : Classe pour définir des polices de caractères.
Event : Classes pour gérer les événements utilisateur.

## ActionListener

`ActionListener` est une interface en Java utilisée pour recevoir des événements d'action, comme les clics de bouton ou les ticks de `Timer`. Elle a une méthode principale :

- **`actionPerformed(ActionEvent e)`** : Méthode appelée lorsqu'une action est déclenchée. Vous y définissez le comportement à exécuter en réponse à l'événement.