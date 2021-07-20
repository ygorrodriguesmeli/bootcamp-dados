# *SQL 3 - Movies DB*

## 1. Explique o conceito de normalização e para que é usado.

É um meio de modelar o banco de forma a minimizar redundância no banco. É feita a normalização a partir de alguns detalhes que podem gerar problemas no futuro, onde precisamos remover algumas colunas, criar outras tabelas, modificar relações, entre outros.

Temos então as formas normais, que são:
1. Não admitir repetições ou campos que possuem mais de um valor, ou seja, campos multivalorados.
2. Os registros na tabela, que não são chaves, devem depender da chave primária em sua totalidade e não apenas em parte dela.
3. Evitar atributos que não dependam exclusivamente da chave primária, ou seja, um atributo não chave não deve depender de outro não chave.

## 2. Adicione um filme à tabela de filmes.
```sql
INSERT INTO movies (title, rating, awards, release_date, length) VALUES ("Me Before You", 9.0, 5, '2016-06-16', 120);
```

## 3. Adicione um gênero à tabela de gêneros.
```sql
INSERT INTO genres (name, ranking, active) VALUES ("Romance", 13, 1);
```

## 4. Associe o filme do Ex 2. ao gênero criado no Ex. 3.
```sql
UPDATE movies SET genre_id = 13 WHERE id=22;
```

## 5. Modifique a tabela de atores para que pelo menos um ator adicione como favorito o filme adicionado no Ex. 2.
```sql
INSERT INTO actor_movie (actor_id, movie_id) VALUES (32, 22);
```

## 6. Crie uma cópia temporária da tabela de filmes.
```sql
CREATE TEMPORARY TABLE new_movies SELECT * FROM movies;
```

## 7. Elimine desta tabela temporária todos os filmes que ganharam menos de 5 prêmios.
```sql
DELETE FROM new_movies WHERE awards < 5;
```

## 8. Obtenha a lista de todos os gêneros que possuem pelo menos um filme.

## 9. Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.

## 10. Use o plano de explicação para analisar as consultas nos Ex. 6 e 7.

## 11. O que são os índices? Para que servem?

## 12. Crie um índice sobre o nome na tabela de filmes.

## 13. Verifique se o índice foi criado corretamente.
