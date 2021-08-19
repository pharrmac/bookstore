DELETE FROM book;
ALTER TABLE book AUTO_INCREMENT = 1001;

DELETE FROM category;
ALTER TABLE category AUTO_INCREMENT = 1001;

INSERT INTO `category` (`name`) VALUES
    ('New releases'),('Best sellers'), ('Young adult'), ('Science fiction'),('Nonfiction'),
     ('Mystery'),('Children''s'),('Horror'),('Historical fiction'),
    ('Fiction'), ('Memoir & autobiography'),('Graphic novels & comics'),
     ('Book club'),
    ('Ebooks'),('Fantasy'),('Psychology'),
    ('Biography'),('Business'),('Chick-lit'),('Classics'),('Contemporary'),
    ('War'), ('Art'),('Cookbooks'),('Crime'),('Gay and lesbian'),('History'),
    ('Humor & comedy'),('Manga'),('Christian'), ('Self help'),
    ('Philosophy'),('Religion');
INSERT INTO `book` (title, author, description, price, rating, is_public, is_featured, category_id) VALUES ('People We Meet On Vacation', 'Emily Henry', 'Poppy and Alex. Alex and Poppy. They have nothing in common. She’s a wild child; he wears khakis. She has insatiable wanderlust; he prefers to stay home with a book. And somehow, ever since a fateful car share home from college many years ago, they are the very best of friends. For most of the year they live far apart—she’s in New York City, and he’s in their small hometown—but every summer, for a decade, they have taken one glorious week of vacation together. ', 1399, 0, FALSE, TRUE, 1001);
INSERT INTO `book` (title, author, description, price, rating, is_public, is_featured, category_id) VALUES ('The Last Thing He Told Me', 'Laura Dave', 'Before Owen Michaels disappears, he smuggles a note to his beloved wife of one year: Protect her. Despite her confusion and fear, Hannah Hall knows exactly to whom the note refers—Owen’s sixteen-year-old daughter, Bailey. Bailey, who lost her mother tragically as a child. Bailey, who wants absolutely nothing to do with her new stepmother.', 2049, 0,  FALSE, TRUE, 1001);
INSERT INTO `book` (title, author, description, price, rating, is_public, is_featured, category_id) VALUES ('The President''s Daughter', 'Bill Clinton and James Patterson', 'This fast-action adventure is a certified nail-biter from the very first page, with details only a former president could write and action only Patterson could dream up. Just imagine the president as a superhero — all the fun without the cape!', 1499, 0, FALSE, TRUE, 1001);
INSERT INTO `book` (title, author, description, price, rating, is_public, is_featured, category_id) VALUES ('Malibu Rising', 'Taylor Jenkins Reid', 'Taking place over the course of just 24 hours, this unforgettable story set in 1980s Southern California follows the Riva siblings as they navigate family drama, personal tragedies and their own insecurities. This final book in Reid''s California trilogy, which also includes the bestsellers Daisy Jones & the Six and The Seven Husbands of Evelyn Hugo, is a perfect summer beach read!', 2099, 0, FALSE, TRUE, 1001);

INSERT INTO `book` (title, author, description, price, rating, is_public, is_featured, category_id) VALUES ('Three Pianos: A Memoir', 'Andrew McMahon', 'From beloved indie musician Andrew McMahon comes a searingly honest and beautifully written memoir about the challenges and triumphs of his life and career, as seen through the lens of his personal connection to three pianos. ', 2799, 0, FALSE, TRUE, 1002);
INSERT INTO `book` (title, author, description, price, rating, is_public, is_featured, category_id) VALUES ('Jujutsu Kaisen, Vol. 1', 'Gege Akutami', 'Yuji Itadori is resolved to save the world from cursed spirits, but he soon learns that the best way to do it is to slowly lose his humanity and become one himself!', 999, 0,  FALSE, TRUE, 1002);
INSERT INTO `book` (title, author, description, price, rating, is_public, is_featured, category_id) VALUES ('The First 21 ', 'Nikki Sixx', 'Rock-and-roll icon and three-time bestselling author Nikki Sixx tells his origin story: how Frank Feranna became Nikki Sixx, chronicling his fascinating journey from irrepressible Idaho farmboy to the man who formed the revolutionary rock group Mötley Crüe.', 3000, 0, FALSE, TRUE, 1002);
INSERT INTO `book` (title, author, description, price, rating, is_public, is_featured, category_id) VALUES ('It Ends with Us: A Novel', 'Colleen Hoover', 'In this “brave and heartbreaking novel that digs its claws into you and doesn''t let go, long after you’ve finished it” (Anna Todd, New York Times bestselling author) from the #1 New York Times bestselling author of All Your Perfects, a workaholic with a too-good-to-be-true romance can’t stop thinking about her first love. ', 1499, 0, FALSE, TRUE, 1002);


INSERT INTO `book` (title, author, description, price, rating, is_public, is_featured, category_id) VALUES ('Firekeeper''s Daughter', 'Angeline Boulley', 'Debut author Angeline Boulley has crafted an immersive and heart-stopping thriller told through the eyes of 18-year-old Daunis, a biracial, unenrolled member of the Ojibwe tribe. With crystal meth abuse on the rise in her community, Daunis uses her knowledge of science and native medicine to go undercover as a confidential informant with the FBI, but what she uncovers makes her question everything she’s ever known.', 1499, 0, FALSE, TRUE, 1003);
INSERT INTO `book` (title, author, description, price, rating, is_public, is_featured, category_id) VALUES ('Felix Ever After', 'Kacen Callender', 'Felix Love wants nothing more than to experience his own love story but fears he may be undeserving. When an anonymous troll starts sending him hateful messages and exposes old photos and his deadname to his art school classmates, Felix sets out for revenge. On his quest to uncover the truth, Felix ultimately learns that love has been within his reach the whole time. Felix Ever After is a poignant, personal and deeply heartfelt story of self-discovery.', 1699, 0,  FALSE, TRUE, 1003);
INSERT INTO `book` (title, author, description, price, rating, is_public, is_featured, category_id) VALUES ('These Violent Delights ', 'Chloe Gong', 'Newcomer Chloe Gong’s fierce and imaginative retelling of Romeo and Juliet set in 1920s Shanghai breathes new life into a story we all know and love. With high-stakes action, a ruthless and brilliant cast of characters and, of course, a tense romance, These Violent Delights is an unforgettable ride from start to finish.', 1499, 0, FALSE, TRUE, 1003);
INSERT INTO `book` (title, author, description, price, rating, is_public, is_featured, category_id) VALUES ('Cemetery Boys', 'Aiden Thomas', 'When Yadriel''s traditional Latinx family is unwilling to accept his gender, he takes it upon himself to prove that he is a true brujo by secretly performing the sacred rite ritual with his cousin, Maritza. However, what he doesn''t count on is summoning the ghost of his classmate who doesn''t even know he''s dead – or how he died. Part paranormal fantasy, part mystery, part slow-burn romance, Cemetery Boys is a must-read for lovers of all genres. Major bonus points for the rich, atmospheric setting and the mouth-watering descriptions of his abuelita''s Latin cooking.', 1899, 0, FALSE, TRUE, 1003);

INSERT INTO `book` (title, author, description, price, rating, is_public, is_featured, category_id) VALUES ('Project Hail Mary', 'Andy Weir', 'The only hope for humanity rests with Dr. Ryland Grace — if only he could remember his mission. Andy Weir, the bestselling author of The Martian, delivers another perfect science-based thriller with Project Hail Mary, a tale of impending catastrophe, survival and interstellar adventure.', 2299, 0, FALSE, TRUE, 1004);
INSERT INTO `book` (title, author, description, price, rating, is_public, is_featured, category_id) VALUES ('1984', 'George Orwell', 'Written more than 70 years ago, 1984 was George Orwell’s chilling prophecy about the future. And while 1984 has come and gone, his dystopian vision of a government that will do anything to control the narrative is timelier than ever...', 899, 0,  FALSE, TRUE, 1004);
INSERT INTO `book` (title, author, description, price, rating, is_public, is_featured, category_id) VALUES ('Ready Player One: A Novel ', 'Ernest Cline', 'A world at stake. A quest for the ultimate prize. Are you ready? In the year 2045, reality is an ugly place. The only time Wade Watts really feels alive is when he’s jacked into the OASIS, a vast virtual world where most of humanity spends their days.', 1550, 0, FALSE, TRUE, 1004);
INSERT INTO `book` (title, author, description, price, rating, is_public, is_featured, category_id) VALUES ('Dune', ' Frank Herbert', 'Arguably a masterpiece of the Science Fiction genre, Dune laid the foundation for many of the epics that followed its publication. Herbert addresses overarching themes of family politics, religion, environment, and the all-encompassing temptation of power, all set against the backdrop of a futuristic civilization that, at times, can be unflinchingly prophetic. You will taste the sand in your mouth and soon be hungry for the next installment.', 999, 0, FALSE, TRUE, 1004);

