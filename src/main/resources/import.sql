-- Ingrédient 1
insert into Ingredient (id, nom, description) values (1, 'Polypropylène', 'Un type de plastique résistant aux chocs.');

-- Ingrédient 2
insert into Ingredient (id, nom, description) values (2, 'Colorant organique', 'Pour une variété de couleurs naturelles.');

-- Ingrédient 3
insert into Ingredient (id, nom, description) values (3, 'Adhésif thermofusible', 'Pour une adhérence solide.');

-- Ingrédient 4
insert into Ingredient (id, nom, description) values (4, 'Peinture acrylique', 'Pour des motifs créatifs.');

-- Ingrédient 5
insert into Ingredient (id, nom, description) values (5, 'Moule en aluminium', 'Pour une précision de forme.');

-- Ingrédient 6
insert into Ingredient (id, nom, description) values (6, 'Lubrifiant à base de silicone', 'Pour une excellente glisse.');

-- Ingrédient 7
insert into Ingredient (id, nom, description) values (7, 'Étiquette en papier recyclé', 'Éco-friendly et informatif.');

-- Ingrédient 8
insert into Ingredient (id, nom, description) values (8, 'Emballage en carton kraft', 'Durable et recyclable.');

-- Ingrédient 9
insert into Ingredient (id, nom, description) values (9, 'Marqueur UV réactif', 'Crée des effets lumineux sous UV.');

-- Ingrédient 10
insert into Ingredient (id, nom, description) values (10, 'Élastomère de polyuréthane', 'Offre souplesse et résistance.');

-- Ingrédient 11
insert into Ingredient (id, nom, description) values (11, 'Polyéthylène', 'Un plastique polyvalent.');

-- Ingrédient 12
insert into Ingredient (id, nom, description) values (12, 'Colorant fluorescent', 'Pour une visibilité accrue.');

-- Ingrédient 13
insert into Ingredient (id, nom, description) values (13, 'Adhésif époxy', 'Pour une résistance chimique.');

-- Ingrédient 14
insert into Ingredient (id, nom, description) values (14, 'Peinture phosphorescente', 'Luit dans l''obscurité.');

-- Ingrédient 15
insert into Ingredient (id, nom, description) values (15, 'Moule en acier inoxydable', 'Pour une durabilité accrue.');

-- Ingrédient 16
insert into Ingredient (id, nom, description) values (16, 'Lubrifiant à base d''eau', 'Pour une option non-toxique.');

-- Ingrédient 17
insert into Ingredient (id, nom, description) values (17, 'Étiquette holographique', 'Pour un aspect futuriste.');

-- Ingrédient 18
insert into Ingredient (id, nom, description) values (18, 'Emballage en plastique recyclé', 'Contribue à la réduction des déchets.');

-- Ingrédient 19
insert into Ingredient (id, nom, description) values (19, 'Marqueur thermochromique', 'Change de couleur en réaction à la chaleur.');

-- Ingrédient 20
insert into Ingredient (id, nom, description) values (20, 'Élastique en caoutchouc naturel', 'Pour une flexibilité supérieure.');

-- Produit 1
insert into Product (id, nom, description, pUHT, gamme) values (1, 'Freesebe Classique', 'Le freesebe classique pour une utilisation en plein air.', '19.99', 'Standard');

-- Produit 2
insert into Product (id, nom, description, pUHT, gamme) values (2, 'Freesebe Pro', 'Un freesebe professionnel avec une précision accrue.', '29.99', 'Pro');

-- Produit 3
insert into Product (id, nom, description, pUHT, gamme) values (3, 'Freesebe Glow', 'Le freesebe qui brille dans l''obscurité pour des parties nocturnes.', '24.99', 'Lumineux');

-- Produit 4
insert into Product (id, nom, description, pUHT, gamme) values (4, 'Freesebe Junior', 'Un freesebe conçu spécialement pour les enfants.', '14.99', 'Enfant');

-- Produit 5
insert into Product (id, nom, description, pUHT, gamme) values (5, 'Freesebe Ultimate', 'Le freesebe ultime pour des performances de pointe.', '39.99', 'Haut de gamme');

-- Relation entre Produit 1 et Ingrédient 1
insert into ProductIngredient (id, product_id, ingredient_id, grammage) values (1, 1, 1, 100);

-- Relation entre Produit 1 et Ingrédient 2
insert into ProductIngredient (id, product_id, ingredient_id, grammage) values (2, 1, 2, 200);

-- Relation entre Produit 1 et Ingrédient 3
insert into ProductIngredient (id, product_id, ingredient_id, grammage) values (3, 1, 3, 150);

-- Relation entre Produit 2 et Ingrédient 4
insert into ProductIngredient (id, product_id, ingredient_id, grammage) values (4, 2, 4, 180);

-- Relation entre Produit 2 et Ingrédient 5
insert into ProductIngredient (id, product_id, ingredient_id, grammage) values (5, 2, 5, 250);

-- Relation entre Produit 3 et Ingrédient 1
insert into ProductIngredient (id, product_id, ingredient_id, grammage) values (6, 3, 1, 120);

-- Relation entre Produit 3 et Ingrédient 6
insert into ProductIngredient (id, product_id, ingredient_id, grammage) values (7, 3, 6, 90);

-- Relation entre Produit 4 et Ingrédient 2
insert into ProductIngredient (id, product_id, ingredient_id, grammage) values (8, 4, 2, 180);

-- Relation entre Produit 4 et Ingrédient 7
insert into ProductIngredient (id, product_id, ingredient_id, grammage) values (9, 4, 7, 50);

-- Relation entre Produit 5 et Ingrédient 3
insert into ProductIngredient (id, product_id, ingredient_id, grammage) values (10, 5, 3, 220);

-- Relation entre Produit 5 et Ingrédient 8
insert into ProductIngredient (id, product_id, ingredient_id, grammage) values (11, 5, 8, 75);