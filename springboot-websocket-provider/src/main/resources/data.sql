INSERT INTO canal (descricao_canal, nome_canal) VALUES ('Venda para empresas', 'B2B');
INSERT INTO canal (descricao_canal, nome_canal) VALUES ('Venda para consumidor final', 'B2C');

INSERT INTO promocao (nome_promocao, descricao_promocao) VALUES ('Dia das Maes', 'Promoção para o Dia das Mães 2023');
INSERT INTO promocao (nome_promocao, descricao_promocao) VALUES ('Dia do Pais', 'Promoção para o Dia dos Pais 2023');

INSERT INTO promocao_canal (id_promocao, id_canal) VALUES (1, 1);
INSERT INTO promocao_canal (id_promocao, id_canal) VALUES (1, 2);
INSERT INTO promocao_canal (id_promocao, id_canal) VALUES (2, 1);
INSERT INTO promocao_canal (id_promocao, id_canal) VALUES (2, 2);

