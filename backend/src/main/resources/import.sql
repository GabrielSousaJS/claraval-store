-- Privilégios
INSERT INTO tb_privilege (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_privilege (authority) VALUES ('ROLE_SELLER');
INSERT INTO tb_privilege (authority) VALUES ('ROLE_CLIENT');

-- Categorias
INSERT INTO categories (name, created_At) VALUES ('Electronics', NOW());
INSERT INTO categories (name, created_At) VALUES ('Apparel', NOW());
INSERT INTO categories (name, created_At) VALUES ('Home and decor items', NOW());
INSERT INTO categories (name, created_At) VALUES ('Sporting goods', NOW());
INSERT INTO categories (name, created_At) VALUES ('Books', NOW());
INSERT INTO categories (name, created_At) VALUES ('Toys and games', NOW());

-- Endereços
INSERT INTO addresses (public_Place, cep, number, city, state, created_At) VALUES ('Rua Augusta', '01305-100', 1200, 'São Paulo', 'São Paulo', NOW());
INSERT INTO addresses (public_Place, cep, number, city, state, created_At) VALUES ('Avenida Atlântica', '22011-010', 1500, 'Rio de Janeiro', 'Rio de Janeiro', NOW());
INSERT INTO addresses (public_Place, cep, number, city, state, created_At) VALUES ('Rua Sergipe', '30130-170', 800, 'Belo Horizonte', 'Minas Gerais', NOW());
INSERT INTO addresses (public_Place, cep, number, city, state, created_At) VALUES ('Setor Comercial Sul', '70390-901', 3, 'Brasília', 'Distrito Federal', NOW());
INSERT INTO addresses (public_Place, cep, number, city, state, created_At) VALUES ('Rua Visconde do Rio Branco', '80420-210', 1500, 'Curitiba', 'Paraná', NOW());
INSERT INTO addresses (public_Place, cep, number, city, state, created_At) VALUES ('Avenida Beira Mar', '60165-121', 100, 'Fortaleza', 'Ceára', NOW());
INSERT INTO addresses (public_Place, cep, number, city, state, created_At) VALUES ('Rua do Bom Jesus', '50030-170', 200, 'Recife', 'Pernambuco', NOW());
INSERT INTO addresses (public_Place, cep, number, city, state, created_At) VALUES ('Avenida Oceânica', '40140-130', 300, 'Salvador', 'Bahia', NOW());
INSERT INTO addresses (public_Place, cep, number, city, state, created_At) VALUES ('Rua Bocaiúva', '88015-530', 500, 'Florianópolis', 'Santa Catarina', NOW());
INSERT INTO addresses (public_Place, cep, number, city, state, created_At) VALUES ('Rua da Praia', '90010-230', 1000, 'Porto Alegre', 'Rio Grande do Sul', NOW());

-- Usuários
INSERT INTO users (name, birth_Date, email, password, address_id, created_At) VALUES ('Gabriela Oliveira', TIMESTAMP WITH TIME ZONE '1994-11-18', 'gabriela.oliveira@gmail.com', '$2a$10$R6Sppkl7ZTrqa0zc5m480.5j5yUJyls/qaRA2g47kuq2MqcjBcHIm', 1, NOW());
INSERT INTO users (name, birth_Date, email, password, address_id, created_At) VALUES ('Marcelo Costa', TIMESTAMP WITH TIME ZONE '1988-07-06', 'marcelo.costa@gmail.com', '$2a$10$0JrJjMHhgursxEHrA8od5.BpakabJfQHIzmM.NMTw263X/AKCKFvK', 2, NOW());
INSERT INTO users (name, birth_Date, email, password, address_id, created_At) VALUES ('Amanda Almeida', TIMESTAMP WITH TIME ZONE '1990-02-28', 'amanda.almeida@gmail.com', '$2a$10$nKt4ooP6e3axe7iXqytjcOREMdXbBonSgm1rhBciD/0K60ZUMefJq', 3, NOW());
INSERT INTO users (name, birth_Date, email, password, address_id, created_At) VALUES ('Renato Nunes', TIMESTAMP WITH TIME ZONE '1995-05-11', 'renato.nunes@gmail.com', '$2a$10$i9U7Ro3FlP9ct8BmftASU.qRN4sMiOErOnNYdoAI6W3ZXKx88lyTS', 4, NOW());
INSERT INTO users (name, birth_Date, email, password, address_id, created_At) VALUES ('Maria Santana', TIMESTAMP WITH TIME ZONE '1992-09-02', 'maria.santana@gmail.com', '$2a$10$QRt.m6epO0umO/1c.7zFQu/txwMrIP3YaOea7k2BJJAmcjqx.t0Wq', 5, NOW());
INSERT INTO users (name, birth_Date, email, password, address_id, created_At) VALUES ('João Carvalho', TIMESTAMP WITH TIME ZONE '1989-12-15', 'joao.carvalho@gmail.com', '$2a$10$wwJgEPVqmoJ34kKJLMTjnOa5IAFfppqgM1THjcCGPktOR/fKV41DK', 6, NOW());
INSERT INTO users (name, birth_Date, email, password, address_id, created_At) VALUES ('Natália Silveira', TIMESTAMP WITH TIME ZONE '1999-03-25', 'natalia.silveira@gmail.com', '$2a$10$f5c1GCc3Yga6yaMIgMFVtuQBa9kGB1FviCi4pMGpd1AH/plpVxJ/q', 7, NOW());
INSERT INTO users (name, birth_Date, email, password, address_id, created_At) VALUES ('Ricardo Ferreira', TIMESTAMP WITH TIME ZONE '1991-06-19', 'ricardo.ferreira@gmail.com', '$2a$10$XPvvBZ4se.jDXC5fQSWHt.cbUPif4nWY.mmR4.h6hEMl0L3pyZ1Be', 8, NOW());
INSERT INTO users (name, birth_Date, email, password, address_id, created_At) VALUES ('Fernanda Mendes', TIMESTAMP WITH TIME ZONE '1994-08-30', 'fernanda.mendes@gmail.com', '$2a$10$NvZa12kC5T27/95FYN2hX.Rm./qdIf2TA5SzKFaKU1TK.bwY7EsMu', 9, NOW());
INSERT INTO users (name, birth_Date, email, password, address_id, created_At) VALUES ('Lucas Barbosa', TIMESTAMP WITH TIME ZONE '1998-02-07', 'lucas.barbosa@gmail.com', '$2a$10$8LNr5i7sogw79M71yHrMceDfXiS8JLcX95gLSynK091nfHQMkbPHe', 10, NOW());

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
INSERT INTO sellers (id, company_name) VALUES (2, 'TechToys');
INSERT INTO sellers (id, company_name) VALUES (3, 'SportWear');
INSERT INTO sellers (id, company_name) VALUES (4, 'Ambience Home');
INSERT INTO sellers (id, company_name) VALUES (5, 'Arcadia Books');

-- Eletrônicos
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('iPhone 13 Pro', 'The latest flagship smartphone from Apple featuring a stunning Super Retina XDR display, A15 Bionic chip, Pro camera system, 5G connectivity, and iOS 15.', 6291.30, 17,'https://www.example.com/images/iphone13pro.jpg', 2, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('iPad Pro (2021)', 'The ultimate tablet for power users with an M1 chip, 12.9-inch Liquid Retina XDR display, 5G connectivity, and support for Apple Pencil and Magic Keyboard.', 8194.70, 10,'https://www.example.com/images/ipadpro2021.jpg', 2, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Dell XPS 13 (2021)', 'A beautifully designed laptop with a virtually borderless display, 11th Gen Intel Core processors, and advanced thermal technology for improved performance.', 6919.70, 22,'https://www.example.com/images/dellxps13.jpg', 2, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Samsung QN90A Neo QLED', 'Experience the next level of picture quality with Samsung Neo QLED technology. Features an ultra-slim design, 4K resolution, and powerful AI upscaling.', 11336.70, 5,'https://www.example.com/images/samsungqn90a.jpg', 2, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Canon EOS R6', 'A full-frame mirrorless camera with advanced autofocus and image stabilization, 4K video recording, and built-in Wi-Fi and Bluetooth connectivity.', 15742.70, 9,'https://www.example.com/images/canoneosr6.jpg', 2, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Bose SoundLink Revolve+', 'A portable Bluetooth speaker with 360-degree sound and up to 16 hours of battery life. Water-resistant and durable, perfect for outdoor use.', 1886.70, 11,'https://www.example.com/images/bosesoundlink.jpg', 2, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('JBL Flip 5 Portable Bluetooth Speaker', 'A compact and powerful Bluetooth speaker with up to 12 hours of battery life, waterproof design, and PartyBoost feature for stereo sound.', 750.30, 25,'https://www.example.com/images/jblflip5.jpg', 2, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Xbox Series X', 'The Xbox Series X is a powerful next-generation gaming console from Microsoft, featuring a custom AMD Zen 2 processor, 16GB of GDDR6 RAM, and a 1TB solid-state drive.', 3145.70, 13,'https://example.com/xboxseriesx.jpg', 2, NOW());

-- Vestuário
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Basic T-shirt', '100% cotton unisex T-shirt', 29.90, 18,'https://example.com/img/t-shirt.jpg', 3, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Hoodie sweatshirt', '100% cotton hoodie sweatshirt, lined, with hood', 89.90, 24,'https://example.com/img/hoodie.jpg', 3, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Jeans pants', 'Slim fit jeans pants, dark wash', 119.90, 8,'https://example.com/img/jeans-pants.jpg', 3, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Leather jacket', 'Synthetic leather jacket, lined, with zipper', 199.90, 12,'https://example.com/img/leather-jacket.jpg', 3, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Dress shoes', 'Classic leather dress shoes', 179.90, 16,'https://example.com/img/dress-shoes.jpg', 3, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Beach shorts', 'Printed beach shorts, men model', 49.90, 23,'https://example.com/img/beach-shorts.jpg', 3, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Long dress', 'Printed long dress, women model', 149.90, 21,'https://example.com/img/long-dress.jpg', 3, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Sport sneakers', 'Knit sport sneakers, with rubber sole', 99.90, 7,'https://example.com/img/sport-sneakers.jpg', 3, NOW());

-- Itens para casa e decoração
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Floral Print Cushion Cover', 'Cushion cover with floral print, made of cotton', 19.99, 14,'https://example.com/img/floral-cushion-cover.jpg', 4, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Abstract Canvas Wall Art', 'Abstract canvas wall art, hand-painted, 36x24 inches', 129.99, 19,'https://example.com/img/abstract-canvas-wall-art.jpg', 4, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Scented Candle', 'Scented candle with lavender fragrance, made of soy wax', 29.99, 20,'https://example.com/img/scented-candle.jpg', 4, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Decorative Wall Mirror', 'Decorative wall mirror with gold frame, 30x24 inches', 89.99, 6,'https://example.com/img/decorative-wall-mirror.jpg', 4, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Area Rug', 'Area rug with geometric pattern, made of wool, 6x9 feet', 299.99, 15,'https://example.com/img/area-rug.jpg', 4, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Table Lamp', 'Table lamp with ceramic base and linen shade', 59.99, 11,'https://example.com/img/table-lamp.jpg', 4, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Decorative Throw Pillow', 'Decorative throw pillow with geometric print, made of cotton, 18x18 inches', 24.99, 25,'https://example.com/img/decorative-throw-pillow.jpg', 4, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Wall Clock', 'Wall clock with wooden frame and metal hands, 12 inches', 39.99, 16,'https://example.com/img/wall-clock.jpg', 4, NOW());

-- Artigos esportivos
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Running shoes', 'Breathable running shoes, perfect for outdoor activities', 119.90, 9,'https://example.com/img/running-shoes.jpg', 3, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Yoga mat', 'Non-slip yoga mat with comfortable cushioning', 69.90, 20,'https://example.com/img/yoga-mat.jpg', 3, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Dumbbell set', 'Set of 2 dumbbells, adjustable weight from 2 to 10kg', 249.90, 17,'https://example.com/img/dumbbell-set.jpg', 3, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Cycling helmet', 'Lightweight cycling helmet with adjustable strap', 89.90, 22,'https://example.com/img/cycling-helmet.jpg', 3, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Basketball', 'Indoor/outdoor basketball, official size and weight', 39.90, 7,'https://example.com/img/basketball.jpg', 3, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Tennis racket', 'Lightweight tennis racket with carbon fiber frame', 149.90, 14,'https://example.com/img/tennis-racket.jpg', 3, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Swimming goggles', 'Anti-fog swimming goggles with UV protection', 29.90, 12,'https://example.com/img/swimming-goggles.jpg', 3, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Fitness tracker', 'Smartwatch with heart rate monitor and step counter', 199.90, 8,'https://example.com/img/fitness-tracker.jpg', 3, NOW());

-- Livros
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('The Lord of The Rings', 'Fantasy novel by J.R.R. Tolkien', 79.99, 23,'https://example.com/img/lotr.jpg', 5, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('1984', 'Dystopian novel by George Orwell', 29.90, 19,'https://example.com/img/1984.jpg', 5, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('To Kill a Mockingbird', 'Novel by Harper Lee', 39.99, 21,'https://example.com/img/mockingbird.jpg', 5, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Pride and Prejudice', 'Novel by Jane Austen', 24.99, 10,'https://example.com/img/pride.jpg', 5, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('The Catcher in the Rye', 'Novel by J.D. Salinger', 34.90, 6,'https://example.com/img/catcher.jpg', 5, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('The Great Gatsby', 'Novel by F. Scott Fitzgerald', 49.90, 15,'https://example.com/img/gatsby.jpg', 5, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('The Hobbit', 'Fantasy novel by J.R.R. Tolkien', 44.99, 18,'https://example.com/img/hobbit.jpg', 5, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('The Da Vinci Code', 'Mystery novel by Dan Brown', 29.99, 5,'https://example.com/img/davinci.jpg', 5, NOW());

-- Brinquedos e jogos
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Action figure', 'Action figure of Spider-Man, 15 cm tall, articulated', 39.90, 24,'https://example.com/img/spiderman.jpg', 4, NOW());

INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Board game', 'Monopoly board game, classic edition', 79.90, 13,'https://example.com/img/monopoly.jpg', 2, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Lego set', 'Lego set of Harry Potter Hogwarts Castle, 6020 pieces', 1999.90, 16,'https://example.com/img/lego-harrypotter.jpg', 2, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Puzzle', '1000 piece puzzle of Van Gogh Starry Night', 49.90, 7,'https://example.com/img/puzzle-vangogh.jpg', 2, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Barbie doll', 'Barbie doll of Olympic athlete, fully articulated', 79.90, 20,'https://example.com/img/barbie-athlete.jpg', 2, NOW());
INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('RC car', 'RC car of Lamborghini Aventador, 1:24 scale', 149.90, 19,'https://example.com/img/rc-car-lambo.jpg', 2, NOW());

INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('Funko Pop', 'Funko Pop figure of Darth Vader from Star Wars', 49.90, 11,'https://example.com/img/funko-darthvader.jpg', 4, NOW());

INSERT INTO products (name, description, price, quantity, img_Url, seller_id, created_At) VALUES ('FIFA 22', 'Video game of FIFA 22 for Xbox Series X', 299.90, 25,'https://example.com/img/fifa22-xbox.jpg', 2, NOW());

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
INSERT INTO product_category (category_id, product_id) VALUES (1, 48);

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
INSERT INTO product_category (category_id, product_id) VALUES (3, 47);

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
INSERT INTO product_category (category_id, product_id) VALUES (5, 40);

-- Produtos de brinquedos e jogos
INSERT INTO product_category (category_id, product_id) VALUES (6, 41);
INSERT INTO product_category (category_id, product_id) VALUES (6, 42);
INSERT INTO product_category (category_id, product_id) VALUES (6, 43);
INSERT INTO product_category (category_id, product_id) VALUES (6, 44);
INSERT INTO product_category (category_id, product_id) VALUES (6, 45);
INSERT INTO product_category (category_id, product_id) VALUES (6, 46);
INSERT INTO product_category (category_id, product_id) VALUES (6, 47);
INSERT INTO product_category (category_id, product_id) VALUES (6, 48);

INSERT INTO product_category (category_id, product_id) VALUES (6, 8);

-- Pedidos
INSERT INTO orders (moment, order_Status, client_id) VALUES (TIMESTAMP WITH TIME ZONE '2023-03-05T18:55:00Z', 'Paid', 6);

-- Itens
INSERT INTO order_item (product_id, order_id, quantity) VALUES (1, 1, 2);

-- Payment
INSERT INTO payments (moment, payment_Method, order_id) VALUES (TIMESTAMP WITH TIME ZONE '2023-03-05T19:10:00Z', 'PIX', 1);