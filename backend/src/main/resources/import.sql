-- Privilégios
INSERT INTO tb_privilege (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_privilege (authority) VALUES ('ROLE_CLIENT');

-- Categorias
INSERT INTO categories (name, created_At) VALUES ('Eletrônicos', NOW());
INSERT INTO categories (name, created_At) VALUES ('Vestuário', NOW());
INSERT INTO categories (name, created_At) VALUES ('Artigos para casa e decoração', NOW());
INSERT INTO categories (name, created_At) VALUES ('Artigos esportivos', NOW());
INSERT INTO categories (name, created_At) VALUES ('Livros', NOW());
INSERT INTO categories (name, created_At) VALUES ('Brinquedos e jogos', NOW());

-- Endereços
INSERT INTO addresses (public_Place, cep, number, city, state, country, created_At) VALUES ('Rua Augusta', '01305-100', 1200, 'São Paulo', 'São Paulo', 'Brasil', NOW());
INSERT INTO addresses (public_Place, cep, number, city, state, country, created_At) VALUES ('Avenida Atlântica', '22011-010', 1500, 'Rio de Janeiro', 'Rio de Janeiro', 'Brasil', NOW());
INSERT INTO addresses (public_Place, cep, number, city, state, country, created_At) VALUES ('Rua Sergipe', '30130-170', 800, 'Belo Horizonte', 'Minas Gerais', 'Brasil', NOW());
INSERT INTO addresses (public_Place, cep, number, city, state, country, created_At) VALUES ('Setor Comercial Sul', '70390-901', 3, 'Brasília', 'Distrito Federal', 'Brasil', NOW());
INSERT INTO addresses (public_Place, cep, number, city, state, country, created_At) VALUES ('Rua Visconde do Rio Branco', '80420-210', 1500, 'Curitiba', 'Paraná', 'Brasil', NOW());

-- Usuários
INSERT INTO users (name, birth_Date, email, password, address_id, created_At) VALUES ('Gabriela Oliveira', TIMESTAMP WITH TIME ZONE '1994-11-18', 'gabriela.oliveira@gmail.com', '$2a$10$R6Sppkl7ZTrqa0zc5m480.5j5yUJyls/qaRA2g47kuq2MqcjBcHIm', 1, NOW());
INSERT INTO users (name, birth_Date, email, password, address_id, created_At) VALUES ('Marcelo Costa', TIMESTAMP WITH TIME ZONE '1988-07-06', 'marcelo.costa@gmail.com', '$2a$10$0JrJjMHhgursxEHrA8od5.BpakabJfQHIzmM.NMTw263X/AKCKFvK', 2, NOW());
INSERT INTO users (name, birth_Date, email, password, address_id, created_At) VALUES ('Amanda Almeida', TIMESTAMP WITH TIME ZONE '1990-02-28', 'amanda.almeida@gmail.com', '$2a$10$nKt4ooP6e3axe7iXqytjcOREMdXbBonSgm1rhBciD/0K60ZUMefJq', 3, NOW());
INSERT INTO users (name, birth_Date, email, password, address_id, created_At) VALUES ('Renato Nunes', TIMESTAMP WITH TIME ZONE '1995-05-11', 'renato.nunes@gmail.com', '$2a$10$i9U7Ro3FlP9ct8BmftASU.qRN4sMiOErOnNYdoAI6W3ZXKx88lyTS', 4, NOW());
INSERT INTO users (name, birth_Date, email, password, address_id, created_At) VALUES ('Maria Santana', TIMESTAMP WITH TIME ZONE '1992-09-02', 'maria.santana@gmail.com', '$2a$10$QRt.m6epO0umO/1c.7zFQu/txwMrIP3YaOea7k2BJJAmcjqx.t0Wq', 5, NOW());

-- Administrador
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (1, 1);
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (1, 2);

-- Clientes
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (2, 2);
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (3, 2);
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (4, 2);
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (5, 2);

-- Eletrônicos
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('iPhone 13 Pro', 'O mais recente smartphone topo de gama da Apple com um impressionante ecrã Super Retina XDR, chip A15 Bionic, sistema de câmara Pro, conectividade 5G e iOS 15.', 6291.30, 17,'https://images-americanas.b2w.io/produtos/01/00/img/3919423/9/3919423949_1GG.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('iPad Pro (2021)', 'O melhor tablet para usuários avançados com chip M1, tela Liquid Retina XDR de 12,9 polegadas, conectividade 5G e suporte para Apple Pencil e Magic Keyboard.', 8194.70, 10,'https://images-americanas.b2w.io/produtos/01/00/img/321640891/0/3216408988_1GG.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Dell XPS 13 (2021)', 'Um laptop de design bonito com tela praticamente sem bordas, processadores Intel Core de 11ª geração e tecnologia térmica avançada para desempenho aprimorado.', 6919.70, 22,'https://images-americanas.b2w.io/produtos/7345859451/imagens/notebook-asus-vivobook-15-x1500ea-ej3671-intel-core-i5-1135g7-2-4-ghz-16gb-ram-512gb-ssd-linux-endless-os-15-6-led-fhd-intel-iris-xe-prata-metalico/7345859451_1_large.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Samsung QN90A Neo QLED', 'Experimente o próximo nível de qualidade de imagem com a tecnologia Samsung Neo QLED. Apresenta um design ultrafino, resolução 4K e poderoso upscaling de IA.', 11336.70, 5,'https://images-americanas.b2w.io/produtos/01/00/img/5021464/3/5021464322_1GG.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Canon EOS R6', 'Uma câmera mirrorless full-frame com foco automático avançado e estabilização de imagem, gravação de vídeo 4K e conectividade Wi-Fi e Bluetooth integrada.', 15742.70, 9,'https://images-americanas.b2w.io/produtos/3564423885/imagens/camera-mirrorless-canon-eos-r6-corpo/3564423922_1_large.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Bose SoundLink Revolve+', 'Um alto-falante Bluetooth portátil com som de 360 graus e até 16 horas de duração da bateria. Resistente à água e durável, perfeito para uso ao ar livre.', 1886.70, 11,'https://images-americanas.b2w.io/produtos/3483794975/imagens/bose-soundlink-revolve-i-i-plus-2021-caixa-portatil-bluetooth-triple-black/3483794975_1_large.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('JBL Flip 5 Bluetooth', 'Um alto-falante Bluetooth compacto e poderoso com até 12 horas de duração da bateria, design à prova d''água e recurso PartyBoost para som estéreo.', 750.30, 25,'https://images-americanas.b2w.io/produtos/5418000673/imagens/caixa-de-som-portatil-jbl-flip-6-bluetooth-5-0-20w-rms-ip67-azul/5418000673_1_large.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Xbox Series X', 'O Xbox Series X é um poderoso console de jogos da próxima geração da Microsoft, apresentando um processador AMD Zen 2 personalizado, 16 GB de RAM GDDR6 e uma unidade de estado sólido de 1 TB.', 3145.70, 13,'https://images-americanas.b2w.io/produtos/01/00/img/2116373/8/2116373802_1GG.jpg', NOW());

-- Vestuário
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Camiseta básica', 'Camiseta unissex 100% algodão', 29.90, 18,'https://images.tcdn.com.br/img/img_prod/1110104/camiseta_basica_bege_unissex_459_1_6ca73d24acc22ae9ff2d6ff80efcaeb8.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Moletom com capuz', 'Moletom moletom 100% algodão, forrado, com capuz, lined, with hood', 89.90, 24,'https://t-static.dafiti.com.br/iXkIGDQqTIN82e8GU-R_O8u6ptw=/fit-in/430x623/static.dafiti.com.br/p/lucas-lunny-moletom-liso-algod%c3%a3o-blusa-de-frio-canguru-flanelado-cinza-9118-73028201-1-zoom.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Calça Jeans', 'Calça jeans slim fit, lavagem escura', 119.90, 8,'https://images.tcdn.com.br/img/img_prod/776144/calca_jeans_skinny_masculina_biotipo_lavagem_escura_2347_1_a31fa2c5601f2ce96159d2d9133bba5d_20220520085651.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Jaqueta de couro', 'Jaqueta de couro sintético, forrada, com zíper', 199.90, 12,'https://m.media-amazon.com/images/I/71h9QfV3y2L._AC_SX522_.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Sapato social', 'Sapatos clássicos de couro', 179.90, 16,'https://cdn.shoppub.io/cdn-cgi/image/w=1000,h=1000,q=80,f=auto/jotape/media/uploads/produtos/foto/b87063aaedf3bsapato_social_com_altura_air_vinitti_preto78205_1.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Calção de praia', 'Calções de praia estampados, modelo homem', 49.90, 23,'https://shophammer.com.br/wp-content/uploads/2022/10/bermuda-tactel-com-elastano-masculina-qualidade-conforto-macies-hammer-bermudas-hammer-45.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Vestido longo', 'Vestido longo estampado, modelo feminino', 149.90, 21,'https://d3ugyf2ht6aenh.cloudfront.net/stores/888/593/products/carol-kucher-202107921-eac52d3ca04bdeb01916221400728604-640-0.webp', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Tênis esportivos', 'Sapatilhas desportivas em malha, com sola de borracha', 99.90, 7,'https://m.media-amazon.com/images/I/61AjhTDFAkL._AC_SY500_.jpg', NOW());

-- Itens para casa e decoração
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Capa de almofada com estampa floral', 'Capa de almofada com estampa floral, confeccionada em algodão', 19.99, 14,'https://img.ltwebstatic.com/images3_pi/2023/03/16/1678959772d6aa7e63673580bbf42092385a57c590_thumbnail_600x.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Arte de parede em tela abstrata', 'Arte de parede em tela abstrata, pintada à mão, 36 x 24 polegadas', 129.99, 19,'https://cdn.awsli.com.br/600x700/539/539164/produto/174867315/5928d6c59c.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Vela perfumada', 'Vela perfumada com fragrância de lavanda, feita de cera de soja', 29.99, 20,'https://m.media-amazon.com/images/I/61jT6rtocsL._AC_SX679_.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Espelho decorativo de parede', 'Espelho decorativo de parede com moldura dourada, 30x24 polegadas', 89.99, 6,'https://m.media-amazon.com/images/I/71tlfoMWe3L._AC_SY741_.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Tapete de área', 'Tapete de área com padrão geométrico, feito de lã, 6x9 pés', 299.99, 15,'https://a-static.mlcdn.com.br/450x450/tapete-de-algodao-colors-g-200x250-artesanal/utilemcasa/c6tw2ptpg/fa32cecf3cb342136a4d498567b62ba7.jpeg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Lâmpada de mesa', 'Candeeiro de mesa com base em cerâmica e abajur de linho', 59.99, 11,'https://m.media-amazon.com/images/I/510SeRtQxzL._AC_SX679_.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Almofada decorativa', 'Almofada decorativa com estampa geométrica, confeccionada em algodão, 18x18 polegadas', 24.99, 25,'https://dmhxz00kguanp.cloudfront.net/fotos/105537/almofada-no-cinza-25cm-259170.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Relógio de parede', 'Relógio de parede com moldura de madeira e ponteiros de metal, 12 polegadas', 39.99, 16,'https://m.media-amazon.com/images/I/61iMyp6x1wL._AC_UF894,1000_QL80_.jpg', NOW());

-- Artigos esportivos
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Tênis de corrida', 'Tênis de corrida respirável, perfeito para atividades ao ar livre', 119.90, 9,'https://static.netshoes.com.br/produtos/tenis-adidas-coreracer-masculino/98/NQQ-4635-298/NQQ-4635-298_zoom1.jpg?ts=1675691074', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Tapete de yoga', 'Tapete de ioga antiderrapante com amortecimento confortável', 69.90, 20,'https://static.netshoes.com.br/produtos/tapete-yoga-mat-pilates-pvc-ecologico-5mm-mandala-yangfit/98/ISQ-0338-198/ISQ-0338-198_zoom1.jpg?ts=1680542512', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Conjunto de halteres', 'Conjunto de 2 halteres, peso regulável de 2 a 10kg', 249.90, 17,'https://m.media-amazon.com/images/I/61R239+-FUL._AC_SX569_.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Capacete de ciclismo', 'Capacete de ciclismo leve com alça ajustável', 89.90, 22,'https://static.netshoes.com.br/produtos/capacete-ciclismo-adulto-resistente-e-leve-bike-tamanho-regulavel-com-viseira/28/DDA-0044-028/DDA-0044-028_zoom1.jpg?ts=1627406195', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Bola de basquete', 'Basquete indoor/outdoor, tamanho e peso oficial', 39.90, 7,'https://static.netshoes.com.br/produtos/bola-de-basquete-wilson-nba-authentic-series-outdoor/42/D25-3697-042/D25-3697-042_zoom1.jpg?ts=1679409479', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Raquete de tênis', 'Raquete de tênis leve com armação de fibra de carbono', 149.90, 14,'https://static.netshoes.com.br/produtos/raquete-de-tenis-babolat-eagle-275g-preta-azul-e-branca/06/2DC-0722-006/2DC-0722-006_zoom1.jpg?ts=1681295902', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Óculos de natação', 'Óculos de natação antiembaçante com proteção UV', 29.90, 12,'https://static.netshoes.com.br/produtos/oculos-de-natacao-speedo-hidrovision-509/06/I46-0197-006/I46-0197-006_zoom1.jpg?ts=1671042190', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Rastreador fitness', 'Smartwatch com monitor de frequência cardíaca e contador de passos', 199.90, 8,'https://m.media-amazon.com/images/I/61UhNKudxiL._AC_SY450_.jpg', NOW());

-- Livros
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('O Senhor dos Anéis', 'Romance de fantasia de J.R.R. Tolkien', 79.99, 23,'https://m.media-amazon.com/images/I/41RBd2DvmgL._SX325_BO1,204,203,200_.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('1984', 'Romance distópico de George Orwell', 29.90, 19,'https://m.media-amazon.com/images/I/51UGhSv+F+L._SX328_BO1,204,203,200_.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Orgulho e Preconceito', 'Romance de Jane Austen', 24.99, 10,'https://m.media-amazon.com/images/I/51AHB+f-0DL._SX335_BO1,204,203,200_.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('O Apanhador no Campo de Centeio', 'Romance de J. D. Salinger', 34.90, 6,'https://m.media-amazon.com/images/I/51Ooch+98bL._SX326_BO1,204,203,200_.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('O Grande Gatsby', 'Romance de F. Scott Fitzgerald', 49.90, 15,'https://m.media-amazon.com/images/I/51yTXz7odDL._SY498_BO1,204,203,200_.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('O Hobbit', 'Romance de fantasia de J.R.R. Tolkien', 44.99, 18,'https://m.media-amazon.com/images/I/511+-lOOtsL._SX319_BO1,204,203,200_.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('O código Da Vinci', 'Romance de mistério de Dan Brown', 29.99, 5,'https://m.media-amazon.com/images/I/41d3LsE0NqL._SX346_BO1,204,203,200_.jpg', NOW());

-- Brinquedos e jogos
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Figura de ação', 'Figura de ação do Homem-Aranha, 15 cm de altura, articulada', 39.90, 24,'https://rihappy.vtexassets.com/arquivos/ids/5288160/Figura-de-Acao---24-Cm---Disney---Marvel---Avenges---Homem-Aranha---Hasbro-0.jpg?v=638074105638570000', NOW());

INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Jogo de tabuleiro', 'Jogo de tabuleiro Monopoly, edição clássica', 79.90, 13,'https://images-americanas.b2w.io/produtos/01/00/img/134450/3/134450322_1GG.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Jogo de lego', 'Conjunto de Lego do Castelo de Hogwarts de Harry Potter, 510 peças', 1999.90, 16,'https://images-americanas.b2w.io/produtos/6131094801/imagens/lego-harry-potter-hogwarts-ala-do-hospital-76398-510-pecas/6131094801_1_large.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Quebra-cabeça', 'Quebra-cabeça de 1000 peças de Van Gogh Starry Night', 49.90, 7,'https://images-americanas.b2w.io/produtos/5094301241/imagens/quebra-cabeca-a-noite-estrelada-van-gogh-1000-pecas-toyster/5094301241_1_large.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Boneca Barbie', 'Boneca Barbie de atleta olímpica, totalmente articulada', 79.90, 20,'https://images-americanas.b2w.io/produtos/467400059/imagens/boneca-barbie-made-to-move-ginasta-articulada-mattel-dvf68/467399545_1_large.jpg', NOW());
INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Carro de controle remoto', 'Carro CR da Lamborghini Aventador, escala 1:24', 149.90, 19,'https://bebeimportadosmiami.com/wp-content/uploads/2020/11/819ts6ScL._AC_SL1500_.jpg', NOW());

INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('Funko Pop', 'Figura Funko Pop de Darth Vader de Star Wars', 49.90, 11,'https://m.media-amazon.com/images/I/6101HDrCVqL._AC_UF894,1000_QL80_.jpg', NOW());

INSERT INTO products (name, description, price, quantity, img_Url, created_At) VALUES ('FIFA 22', 'Jogo eletrônico de FIFA 22 para Xbox Series X', 299.90, 25,'https://m.media-amazon.com/images/I/810V2t+RstL._AC_UF1000,1000_QL80_.jpg', NOW());

-- Produtos eletrônicos
INSERT INTO product_category (category_id, product_id) VALUES (1, 1);
INSERT INTO product_category (category_id, product_id) VALUES (1, 2);
INSERT INTO product_category (category_id, product_id) VALUES (1, 3);
INSERT INTO product_category (category_id, product_id) VALUES (1, 4);
INSERT INTO product_category (category_id, product_id) VALUES (1, 5);
INSERT INTO product_category (category_id, product_id) VALUES (1, 6);
INSERT INTO product_category (category_id, product_id) VALUES (1, 7);
INSERT INTO product_category (category_id, product_id) VALUES (1, 8);

INSERT INTO product_category (category_id, product_id) VALUES (1, 32);
INSERT INTO product_category (category_id, product_id) VALUES (1, 47);

-- Produtos de vestuário
INSERT INTO product_category (category_id, product_id) VALUES (2, 9);
INSERT INTO product_category (category_id, product_id) VALUES (2, 10);
INSERT INTO product_category (category_id, product_id) VALUES (2, 11);
INSERT INTO product_category (category_id, product_id) VALUES (2, 12);
INSERT INTO product_category (category_id, product_id) VALUES (2, 13);
INSERT INTO product_category (category_id, product_id) VALUES (2, 14);
INSERT INTO product_category (category_id, product_id) VALUES (2, 15);
INSERT INTO product_category (category_id, product_id) VALUES (2, 16);

INSERT INTO product_category (category_id, product_id) VALUES (2, 25);

-- Produtos de itens para casa e decoração
INSERT INTO product_category (category_id, product_id) VALUES (3, 17);
INSERT INTO product_category (category_id, product_id) VALUES (3, 18);
INSERT INTO product_category (category_id, product_id) VALUES (3, 19);
INSERT INTO product_category (category_id, product_id) VALUES (3, 20);
INSERT INTO product_category (category_id, product_id) VALUES (3, 21);
INSERT INTO product_category (category_id, product_id) VALUES (3, 22);
INSERT INTO product_category (category_id, product_id) VALUES (3, 23);
INSERT INTO product_category (category_id, product_id) VALUES (3, 24);

INSERT INTO product_category (category_id, product_id) VALUES (3, 26);
INSERT INTO product_category (category_id, product_id) VALUES (3, 41);
INSERT INTO product_category (category_id, product_id) VALUES (3, 42);
INSERT INTO product_category (category_id, product_id) VALUES (3, 44);
INSERT INTO product_category (category_id, product_id) VALUES (3, 46);

-- Produtos para leitura (livros)
INSERT INTO product_category (category_id, product_id) VALUES (4, 25);
INSERT INTO product_category (category_id, product_id) VALUES (4, 26);
INSERT INTO product_category (category_id, product_id) VALUES (4, 27);
INSERT INTO product_category (category_id, product_id) VALUES (4, 28);
INSERT INTO product_category (category_id, product_id) VALUES (4, 29);
INSERT INTO product_category (category_id, product_id) VALUES (4, 30);
INSERT INTO product_category (category_id, product_id) VALUES (4, 31);
INSERT INTO product_category (category_id, product_id) VALUES (4, 32);

-- Produtos de artigos esportivos
INSERT INTO product_category (category_id, product_id) VALUES (5, 33);
INSERT INTO product_category (category_id, product_id) VALUES (5, 34);
INSERT INTO product_category (category_id, product_id) VALUES (5, 35);
INSERT INTO product_category (category_id, product_id) VALUES (5, 36);
INSERT INTO product_category (category_id, product_id) VALUES (5, 37);
INSERT INTO product_category (category_id, product_id) VALUES (5, 38);
INSERT INTO product_category (category_id, product_id) VALUES (5, 39);


-- Produtos de brinquedos e jogos
INSERT INTO product_category (category_id, product_id) VALUES (6, 40);
INSERT INTO product_category (category_id, product_id) VALUES (6, 41);
INSERT INTO product_category (category_id, product_id) VALUES (6, 42);
INSERT INTO product_category (category_id, product_id) VALUES (6, 43);
INSERT INTO product_category (category_id, product_id) VALUES (6, 44);
INSERT INTO product_category (category_id, product_id) VALUES (6, 45);
INSERT INTO product_category (category_id, product_id) VALUES (6, 46);
INSERT INTO product_category (category_id, product_id) VALUES (6, 47);

INSERT INTO product_category (category_id, product_id) VALUES (6, 8);


-- -- Pedidos
-- INSERT INTO orders (moment, order_Status, client_id) VALUES (TIMESTAMP WITH TIME ZONE '2023-03-05T18:55:00Z', 'Paid', 6);
-- INSERT INTO orders (moment, order_Status, client_id) VALUES (TIMESTAMP WITH TIME ZONE '2023-03-05T18:55:00Z', 'Paid', 6);
--
-- -- Itens
-- INSERT INTO order_item (product_id, order_id, quantity, price) VALUES (1, 1, 2, 699);
-- INSERT INTO order_item (product_id, order_id, quantity, price) VALUES (1, 2, 3, 500);

-- Payment
-- INSERT INTO payments (moment, payment_Method, order_id) VALUES (TIMESTAMP WITH TIME ZONE '2023-03-05T19:10:00Z', 'PIX', 1);
-- INSERT INTO payments (moment, payment_Method, order_id) VALUES (TIMESTAMP WITH TIME ZONE '2023-03-05T19:10:00Z', 'PIX', 2);
