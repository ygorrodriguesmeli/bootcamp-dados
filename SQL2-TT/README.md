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
CREATE TEMPORARY TABLE temp_movies SELECT * FROM movies;
```

## 7. Elimine desta tabela temporária todos os filmes que ganharam menos de 5 prêmios.
```sql
DELETE FROM temp_movies WHERE awards < 5;
```

## 8. Obtenha a lista de todos os gêneros que possuem pelo menos um filme.
```sql
SELECT g.name FROM genres g INNER JOIN movies m ON(g.id = m.genre_id) GROUP BY g.name;
```
| name            |
|-----------------|
| Comedia         |
| Drama           |
| Ciencia Ficcion |
| Suspenso        |
| Animacion       |
| Aventuras       |
| Infantiles      |
| Romance         |

## 9. Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.
```sql
SELECT a.first_name FROM actors a INNER JOIN actor_movie am ON (a.id = am.actor_id) INNER JOIN movies m ON (m.id = am.movie_id) WHERE m.awards > 3 GROUP BY a.first_name;
```
| first_name |
|------------|
| Leonardo   |
| Kate       |
| Billy      |
| Mark       |
| Harrison   |
| Carrie     |
| Sam        |
| Laura      |
| Jeff       |
| Sean       |
| Emilia     |

## 10. Use o plano de explicação para analisar as consultas no Ex. 7.
```sql
7 - EXPLAIN DELETE FROM temp_movies WHERE awards < 5;
```
| id | select_type | table       | partitions | type | possible_keys | key  | key_len | ref  | rows | filtered | Extra       |
|----|:-------------|:-------------|:------------|:------|:---------------|:------|:---------|:------|:------|:----------|:-------------:|
|  1 | DELETE      | temp_movies | NULL       | ALL  | NULL          | NULL | NULL    | NULL |   22 |   100.00 | Using where |

## 11. O que são os índices? Para que servem?
É um mecanismo de otimização para consultas, melhorando o acesso aos dados, fornecendo um caminho direto para os dados armazenados para evitar a execução de varreduras completas dos dados de uma tabela. Elas são bem utilizadas quando se sabe quais são os WHERE e JOIN a serem feitos, antecipando eles para melhorar a consulta.

## 12. Crie um índice sobre o nome na tabela de filmes.
```sql
CREATE INDEX movie_title_idx ON movies (title);
```

## 13. Verifique se o índice foi criado corretamente.
```sql
SHOW INDEX FROM movies;
```
| Table  | Non_unique | Key_name                | Seq_in_index | Column_name | Collation | Cardinality | Sub_part | Packed | Null | Index_type | Comment | Index_comment | Visible | Expression |
|---------|:-------------|:---------------------|:--------------|:------------|:----------|:------------|:----------|:--------|:---------|:-----------|:-------- |:--------------|:-----------|:--------------:|
| movies |          0 | PRIMARY                 |            1 | id          | A         |          21 |     NULL |   NULL |      | BTREE      |         |               | YES     | NULL       |
| movies |          1 | movies_genre_id_foreign |            1 | genre_id    | A         |           8 |     NULL |   NULL | YES  | BTREE      |         |               | YES     | NULL       |
| movies |          1 | movie_title_idx         |            1 | title       | A         |          22 |     NULL |   NULL |      | BTREE      |         |               | YES     | NULL       |
