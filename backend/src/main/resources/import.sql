-- Privilégios
INSERT INTO tb_privilege (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_privilege (authority) VALUES ('ROLE_SELLER');
INSERT INTO tb_privilege (authority) VALUES ('ROLE_CLIENT');

-- Categorias
INSERT INTO tb_category (name) VALUES ('Electronics');
INSERT INTO tb_category (name) VALUES ('Apparel');
INSERT INTO tb_category (name) VALUES ('Home and decor items');
INSERT INTO tb_category (name) VALUES ('Sporting goods');
INSERT INTO tb_category (name) VALUES ('Books');
INSERT INTO tb_category (name) VALUES ('Toys and games');

-- Endereços
INSERT INTO tb_address (public_Place, cep, number, city) VALUES ('Rua Augusta', '01305-100', 1200, 'São Paulo');
INSERT INTO tb_address (public_Place, cep, number, city) VALUES ('Avenida Atlântica', '22011-010', 1500, 'Rio de Janeiro');
INSERT INTO tb_address (public_Place, cep, number, city) VALUES ('Rua Sergipe', '30130-170', 800, 'Belo Horizonte');
INSERT INTO tb_address (public_Place, cep, number, city) VALUES ('Setor Comercial Sul', '70390-901', 3, 'Brasília');
INSERT INTO tb_address (public_Place, cep, number, city) VALUES ('Rua Visconde do Rio Branco', '80420-210', 1500, 'Curitiba');
INSERT INTO tb_address (public_Place, cep, number, city) VALUES ('Avenida Beira Mar', '60165-121', 100, 'Fortaleza');
INSERT INTO tb_address (public_Place, cep, number, city) VALUES ('Rua do Bom Jesus', '50030-170', 200, 'Recife');
INSERT INTO tb_address (public_Place, cep, number, city) VALUES ('Avenida Oceânica', '40140-130', 300, 'Salvador');
INSERT INTO tb_address (public_Place, cep, number, city) VALUES ('Rua Bocaiúva', '88015-530', 500, 'Florianópolis');
INSERT INTO tb_address (public_Place, cep, number, city) VALUES ('Rua da Praia', '90010-230', 1000, 'Porto Alegre');

-- Usuários
INSERT INTO tb_user (firstname, lastname, birth_Date, email, password, address_id) VALUES ('Gabriela', 'Oliveira', TIMESTAMP WITH TIME ZONE '1994-11-18', 'gabriela.oliveira@email.com', '$2a$10$R6Sppkl7ZTrqa0zc5m480.5j5yUJyls/qaRA2g47kuq2MqcjBcHIm', 1);
INSERT INTO tb_user (firstname, lastname, birth_Date, email, password, address_id) VALUES ('Marcelo', 'Costa', TIMESTAMP WITH TIME ZONE '1988-07-06', 'marcelo.costa@email.com', '$2a$10$0JrJjMHhgursxEHrA8od5.BpakabJfQHIzmM.NMTw263X/AKCKFvK', 2);
INSERT INTO tb_user (firstname, lastname, birth_Date, email, password, address_id) VALUES ('Amanda', 'Almeida', TIMESTAMP WITH TIME ZONE '1990-02-28', 'amanda.almeida@email.com', '$2a$10$nKt4ooP6e3axe7iXqytjcOREMdXbBonSgm1rhBciD/0K60ZUMefJq', 3);
INSERT INTO tb_user (firstname, lastname, birth_Date, email, password, address_id) VALUES ('Renato', 'Nunes', TIMESTAMP WITH TIME ZONE '1995-05-11', 'renato.nunes@email.com', '$2a$10$i9U7Ro3FlP9ct8BmftASU.qRN4sMiOErOnNYdoAI6W3ZXKx88lyTS', 4);
INSERT INTO tb_user (firstname, lastname, birth_Date, email, password, address_id) VALUES ('Maria', 'Santana', TIMESTAMP WITH TIME ZONE '1992-09-02', 'maria.santana@email.com', '$2a$10$QRt.m6epO0umO/1c.7zFQu/txwMrIP3YaOea7k2BJJAmcjqx.t0Wq', 5);
INSERT INTO tb_user (firstname, lastname, birth_Date, email, password, address_id) VALUES ('João', 'Carvalho', TIMESTAMP WITH TIME ZONE '1989-12-15', 'joao.carvalho@email.com', '$2a$10$wwJgEPVqmoJ34kKJLMTjnOa5IAFfppqgM1THjcCGPktOR/fKV41DK', 6);
INSERT INTO tb_user (firstname, lastname, birth_Date, email, password, address_id) VALUES ('Natália', 'Silveira', TIMESTAMP WITH TIME ZONE '1999-03-25', 'natalia.silveira@email.com', '$2a$10$f5c1GCc3Yga6yaMIgMFVtuQBa9kGB1FviCi4pMGpd1AH/plpVxJ/q', 7);
INSERT INTO tb_user (firstname, lastname, birth_Date, email, password, address_id) VALUES ('Ricardo', 'Ferreira', TIMESTAMP WITH TIME ZONE '1991-06-19', 'ricardo.ferreira@email.com', '$2a$10$XPvvBZ4se.jDXC5fQSWHt.cbUPif4nWY.mmR4.h6hEMl0L3pyZ1Be', 8);
INSERT INTO tb_user (firstname, lastname, birth_Date, email, password, address_id) VALUES ('Fernanda', 'Mendes', TIMESTAMP WITH TIME ZONE '1994-08-30', 'fernanda.mendes@email.com', '$2a$10$NvZa12kC5T27/95FYN2hX.Rm./qdIf2TA5SzKFaKU1TK.bwY7EsMu', 9);
INSERT INTO tb_user (firstname, lastname, birth_Date, email, password, address_id) VALUES ('Lucas', 'Barbosa', TIMESTAMP WITH TIME ZONE '1998-02-07', 'lucas.barbosa@email.com', '$2a$10$8LNr5i7sogw79M71yHrMceDfXiS8JLcX95gLSynK091nfHQMkbPHe', 10);

-- Administrador
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (1, 1);
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (1, 2);
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (1, 3);

-- Vendedores
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (2, 2);
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (3, 2);
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (4, 2);
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (5, 2);

INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (2, 3);
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (3, 3);
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (4, 3);
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (5, 3);

-- Clientes
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (6, 3);
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (7, 3);
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (8, 3);
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (9, 3);
INSERT INTO tb_user_privilege (user_id, privilege_id) VALUES (10, 3);

-- Vendedores e suas companhias
INSERT INTO tb_userseller (id, company_name) VALUES (2, 'TechToys');
INSERT INTO tb_userseller (id, company_name) VALUES (3, 'SportWear');
INSERT INTO tb_userseller (id, company_name) VALUES (4, 'Ambience Home');
INSERT INTO tb_userseller (id, company_name) VALUES (5, 'Arcadia Books');

-- Eletrônicos
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('iPhone 13 Pro', 'The latest flagship smartphone from Apple featuring a stunning Super Retina XDR display, A15 Bionic chip, Pro camera system, 5G connectivity, and iOS 15.', 6291.30, 17,'https://www.example.com/images/iphone13pro.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('iPad Pro (2021)', 'The ultimate tablet for power users with an M1 chip, 12.9-inch Liquid Retina XDR display, 5G connectivity, and support for Apple Pencil and Magic Keyboard.', 8194.70, 10,'https://www.example.com/images/ipadpro2021.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Dell XPS 13 (2021)', 'A beautifully designed laptop with a virtually borderless display, 11th Gen Intel Core processors, and advanced thermal technology for improved performance.', 6919.70, 22,'https://www.example.com/images/dellxps13.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Samsung QN90A Neo QLED', 'Experience the next level of picture quality with Samsung Neo QLED technology. Features an ultra-slim design, 4K resolution, and powerful AI upscaling.', 11336.70, 5,'https://www.example.com/images/samsungqn90a.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Canon EOS R6', 'A full-frame mirrorless camera with advanced autofocus and image stabilization, 4K video recording, and built-in Wi-Fi and Bluetooth connectivity.', 15742.70, 9,'https://www.example.com/images/canoneosr6.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Bose SoundLink Revolve+', 'A portable Bluetooth speaker with 360-degree sound and up to 16 hours of battery life. Water-resistant and durable, perfect for outdoor use.', 1886.70, 11,'https://www.example.com/images/bosesoundlink.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('JBL Flip 5 Portable Bluetooth Speaker', 'A compact and powerful Bluetooth speaker with up to 12 hours of battery life, waterproof design, and PartyBoost feature for stereo sound.', 750.30, 25,'https://www.example.com/images/jblflip5.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Xbox Series X', 'The Xbox Series X is a powerful next-generation gaming console from Microsoft, featuring a custom AMD Zen 2 processor, 16GB of GDDR6 RAM, and a 1TB solid-state drive.', 3145.70, 13,'https://example.com/xboxseriesx.jpg');

-- Vestuário
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Basic T-shirt', '100% cotton unisex T-shirt', 29.90, 18,'https://example.com/img/t-shirt.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Hoodie sweatshirt', '100% cotton hoodie sweatshirt, lined, with hood', 89.90, 24,'https://example.com/img/hoodie.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Jeans pants', 'Slim fit jeans pants, dark wash', 119.90, 8,'https://example.com/img/jeans-pants.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Leather jacket', 'Synthetic leather jacket, lined, with zipper', 199.90, 12,'https://example.com/img/leather-jacket.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Dress shoes', 'Classic leather dress shoes', 179.90, 16,'https://example.com/img/dress-shoes.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Beach shorts', 'Printed beach shorts, men model', 49.90, 23,'https://example.com/img/beach-shorts.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Long dress', 'Printed long dress, women model', 149.90, 21,'https://example.com/img/long-dress.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Sport sneakers', 'Knit sport sneakers, with rubber sole', 99.90, 7,'https://example.com/img/sport-sneakers.jpg');

-- Itens para casa e decoração
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Floral Print Cushion Cover', 'Cushion cover with floral print, made of cotton', 19.99, 14,'https://example.com/img/floral-cushion-cover.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Abstract Canvas Wall Art', 'Abstract canvas wall art, hand-painted, 36x24 inches', 129.99, 19,'https://example.com/img/abstract-canvas-wall-art.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Scented Candle', 'Scented candle with lavender fragrance, made of soy wax', 29.99, 20,'https://example.com/img/scented-candle.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Decorative Wall Mirror', 'Decorative wall mirror with gold frame, 30x24 inches', 89.99, 6,'https://example.com/img/decorative-wall-mirror.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Area Rug', 'Area rug with geometric pattern, made of wool, 6x9 feet', 299.99, 15,'https://example.com/img/area-rug.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Table Lamp', 'Table lamp with ceramic base and linen shade', 59.99, 11,'https://example.com/img/table-lamp.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Decorative Throw Pillow', 'Decorative throw pillow with geometric print, made of cotton, 18x18 inches', 24.99, 25,'https://example.com/img/decorative-throw-pillow.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Wall Clock', 'Wall clock with wooden frame and metal hands, 12 inches', 39.99, 16,'https://example.com/img/wall-clock.jpg');

-- Artigos esportivos
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Running shoes', 'Breathable running shoes, perfect for outdoor activities', 119.90, 9,'https://example.com/img/running-shoes.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Yoga mat', 'Non-slip yoga mat with comfortable cushioning', 69.90, 20,'https://example.com/img/yoga-mat.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Dumbbell set', 'Set of 2 dumbbells, adjustable weight from 2 to 10kg', 249.90, 17,'https://example.com/img/dumbbell-set.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Cycling helmet', 'Lightweight cycling helmet with adjustable strap', 89.90, 22,'https://example.com/img/cycling-helmet.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Basketball', 'Indoor/outdoor basketball, official size and weight', 39.90, 7,'https://example.com/img/basketball.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Tennis racket', 'Lightweight tennis racket with carbon fiber frame', 149.90, 14,'https://example.com/img/tennis-racket.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Swimming goggles', 'Anti-fog swimming goggles with UV protection', 29.90, 12,'https://example.com/img/swimming-goggles.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Fitness tracker', 'Smartwatch with heart rate monitor and step counter', 199.90, 8,'https://example.com/img/fitness-tracker.jpg');

-- Livros
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('The Lord of The Rings', 'Fantasy novel by J.R.R. Tolkien', 79.99, 23,'https://example.com/img/lotr.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('1984', 'Dystopian novel by George Orwell', 29.90, 19,'https://example.com/img/1984.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('To Kill a Mockingbird', 'Novel by Harper Lee', 39.99, 21,'https://example.com/img/mockingbird.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Pride and Prejudice', 'Novel by Jane Austen', 24.99, 10,'https://example.com/img/pride.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('The Catcher in the Rye', 'Novel by J.D. Salinger', 34.90, 6,'https://example.com/img/catcher.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('The Great Gatsby', 'Novel by F. Scott Fitzgerald', 49.90, 15,'https://example.com/img/gatsby.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('The Hobbit', 'Fantasy novel by J.R.R. Tolkien', 44.99, 18,'https://example.com/img/hobbit.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('The Da Vinci Code', 'Mystery novel by Dan Brown', 29.99, 5,'https://example.com/img/davinci.jpg');

-- Brinquedos e jogos
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Action figure', 'Action figure of Spider-Man, 15 cm tall, articulated', 39.90, 24,'https://example.com/img/spiderman.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Board game', 'Monopoly board game, classic edition', 79.90, 13,'https://example.com/img/monopoly.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Lego set', 'Lego set of Harry Potter Hogwarts Castle, 6020 pieces', 1999.90, 16,'https://example.com/img/lego-harrypotter.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Puzzle', '1000 piece puzzle of Van Gogh Starry Night', 49.90, 7,'https://example.com/img/puzzle-vangogh.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Barbie doll', 'Barbie doll of Olympic athlete, fully articulated', 79.90, 20,'https://example.com/img/barbie-athlete.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('RC car', 'RC car of Lamborghini Aventador, 1:24 scale', 149.90, 19,'https://example.com/img/rc-car-lambo.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('Funko Pop', 'Funko Pop figure of Darth Vader from Star Wars', 49.90, 11,'https://example.com/img/funko-darthvader.jpg');
INSERT INTO tb_product (name, description, price, quantity, img_Url) VALUES ('FIFA 22', 'Video game of FIFA 22 for Xbox Series X', 299.90, 25,'https://example.com/img/fifa22-xbox.jpg');

-- Produtos eletrônicos
INSERT INTO tb_product_category (category_id, product_id) VALUES (1, 1);
INSERT INTO tb_product_category (category_id, product_id) VALUES (1, 2);
INSERT INTO tb_product_category (category_id, product_id) VALUES (1, 3);
INSERT INTO tb_product_category (category_id, product_id) VALUES (1, 4);
INSERT INTO tb_product_category (category_id, product_id) VALUES (1, 5);
INSERT INTO tb_product_category (category_id, product_id) VALUES (1, 6);
INSERT INTO tb_product_category (category_id, product_id) VALUES (1, 7);
INSERT INTO tb_product_category (category_id, product_id) VALUES (1, 8);

INSERT INTO tb_product_category (category_id, product_id) VALUES (1, 32);
INSERT INTO tb_product_category (category_id, product_id) VALUES (1, 48);

-- Produtos de vestuário
INSERT INTO tb_product_category (category_id, product_id) VALUES (2, 9);
INSERT INTO tb_product_category (category_id, product_id) VALUES (2, 10);
INSERT INTO tb_product_category (category_id, product_id) VALUES (2, 11);
INSERT INTO tb_product_category (category_id, product_id) VALUES (2, 12);
INSERT INTO tb_product_category (category_id, product_id) VALUES (2, 13);
INSERT INTO tb_product_category (category_id, product_id) VALUES (2, 14);
INSERT INTO tb_product_category (category_id, product_id) VALUES (2, 15);
INSERT INTO tb_product_category (category_id, product_id) VALUES (2, 16);

INSERT INTO tb_product_category (category_id, product_id) VALUES (2, 25);

-- Produtos de itens para casa e decoração
INSERT INTO tb_product_category (category_id, product_id) VALUES (3, 17);
INSERT INTO tb_product_category (category_id, product_id) VALUES (3, 18);
INSERT INTO tb_product_category (category_id, product_id) VALUES (3, 19);
INSERT INTO tb_product_category (category_id, product_id) VALUES (3, 20);
INSERT INTO tb_product_category (category_id, product_id) VALUES (3, 21);
INSERT INTO tb_product_category (category_id, product_id) VALUES (3, 22);
INSERT INTO tb_product_category (category_id, product_id) VALUES (3, 23);
INSERT INTO tb_product_category (category_id, product_id) VALUES (3, 24);

INSERT INTO tb_product_category (category_id, product_id) VALUES (3, 26);
INSERT INTO tb_product_category (category_id, product_id) VALUES (3, 41);
INSERT INTO tb_product_category (category_id, product_id) VALUES (3, 42);
INSERT INTO tb_product_category (category_id, product_id) VALUES (3, 44);
INSERT INTO tb_product_category (category_id, product_id) VALUES (3, 46);
INSERT INTO tb_product_category (category_id, product_id) VALUES (3, 47);

-- Produtos para leitura (livros)
INSERT INTO tb_product_category (category_id, product_id) VALUES (4, 25);
INSERT INTO tb_product_category (category_id, product_id) VALUES (4, 26);
INSERT INTO tb_product_category (category_id, product_id) VALUES (4, 27);
INSERT INTO tb_product_category (category_id, product_id) VALUES (4, 28);
INSERT INTO tb_product_category (category_id, product_id) VALUES (4, 29);
INSERT INTO tb_product_category (category_id, product_id) VALUES (4, 30);
INSERT INTO tb_product_category (category_id, product_id) VALUES (4, 31);
INSERT INTO tb_product_category (category_id, product_id) VALUES (4, 32);

-- Produtos de artigos esportivos
INSERT INTO tb_product_category (category_id, product_id) VALUES (5, 33);
INSERT INTO tb_product_category (category_id, product_id) VALUES (5, 34);
INSERT INTO tb_product_category (category_id, product_id) VALUES (5, 35);
INSERT INTO tb_product_category (category_id, product_id) VALUES (5, 36);
INSERT INTO tb_product_category (category_id, product_id) VALUES (5, 37);
INSERT INTO tb_product_category (category_id, product_id) VALUES (5, 38);
INSERT INTO tb_product_category (category_id, product_id) VALUES (5, 39);
INSERT INTO tb_product_category (category_id, product_id) VALUES (5, 40);

-- Produtos de brinquedos e jogos
INSERT INTO tb_product_category (category_id, product_id) VALUES (6, 41);
INSERT INTO tb_product_category (category_id, product_id) VALUES (6, 42);
INSERT INTO tb_product_category (category_id, product_id) VALUES (6, 43);
INSERT INTO tb_product_category (category_id, product_id) VALUES (6, 44);
INSERT INTO tb_product_category (category_id, product_id) VALUES (6, 45);
INSERT INTO tb_product_category (category_id, product_id) VALUES (6, 46);
INSERT INTO tb_product_category (category_id, product_id) VALUES (6, 47);
INSERT INTO tb_product_category (category_id, product_id) VALUES (6, 48);

INSERT INTO tb_product_category (category_id, product_id) VALUES (6, 8);