-- Create events table if it doesn't exist
CREATE TABLE IF NOT EXISTS events (
    id UUID PRIMARY KEY,
    accountid UUID NOT NULL,
    name VARCHAR(255) UNIQUE,
    creationdate DATE,
    street VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    zip VARCHAR(20),
    country VARCHAR(255),
    description TEXT,
    startdatetime TIMESTAMP,
    enddatetime TIMESTAMP,
    websiteurl VARCHAR(255),
    imagekey VARCHAR(50),
    likes BIGINT,
    rating DOUBLE PRECISION,
    attendees BIGINT,
    type VARCHAR(255) NOT NULL
);

-- Event table data import statements
-- Each insert statement provides data for a single event with all required fields

-- Tech conferences
INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('f47ac10b-58cc-4372-a567-0e02b2c3d479', 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'DevCon 2025', '2024-09-15', '123 Innovation Way', 'San Francisco', 'CA', '94107', 'USA', 'Annual developer conference featuring the latest in cloud technologies and AI advancements', '2025-06-12T09:00:00', '2025-06-14T17:00:00', 'https://devcon2025.example.com', '/images/devcon2025.jpg', 3456, 4.8, 5000, 'CONFERENCE');

INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('a24a6ea4-ce75-4665-a070-57453082c256', '550e8400-e29b-41d4-a716-446655440000', 'Open Source Summit', '2024-10-01', '456 Freedom Blvd', 'Seattle', 'WA', '98101', 'USA', 'The premier event for open source developers, technologists, and community leaders', '2025-05-03T08:30:00', '2025-05-05T16:30:00', 'https://ossummit.example.org', '/images/ossummit.jpg', 2891, 4.7, 3200, 'CONFERENCE');

-- Music festivals
INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('b8a5d95e-7f3d-4c46-8b0e-574a813f7903', '6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'Harmonic Convergence Festival', '2024-08-23', '789 Melody Lane', 'Austin', 'TX', '78704', 'USA', 'Three days of incredible live music spanning multiple genres with over 100 artists', '2025-07-18T12:00:00', '2025-07-20T23:59:00', 'https://harmonicfest.example.com', '/images/harmonic.jpg', 15782, 4.9, 45000, 'MUSIC_FESTIVAL');

INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('c2e43ae9-56f9-4cd8-9dac-26f4c4bd2d3c', 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'Electronica Now', '2024-11-12', '101 Beat Street', 'Miami', 'FL', '33127', 'USA', 'The ultimate electronic music experience featuring world-renowned DJs and immersive light shows', '2025-03-21T20:00:00', '2025-03-23T06:00:00', 'https://electronicanow.example.net', '/images/electronica.jpg', 9437, 4.6, 28000, 'MUSIC_FESTIVAL');

-- Sports events
INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('d1b48324-9845-4db9-ac1d-7e1f968e49b2', '550e8400-e29b-41d4-a716-446655440000', 'Marathon for Hope', '2024-07-05', '321 Runners Path', 'Chicago', 'IL', '60607', 'USA', 'Annual charity marathon raising funds for cancer research with routes for all skill levels', '2025-05-25T07:00:00', '2025-05-25T15:00:00', 'https://marathonforhope.example.org', '/images/marathon.jpg', 6298, 4.8, 12000, 'SPORTS');

INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('e3c79e2d-7531-4b4c-8d1a-8f6a9e81c0b4', '6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'World Basketball Championship', '2024-09-30', '555 Arena Way', 'Los Angeles', 'CA', '90015', 'USA', 'International basketball championship featuring teams from 24 countries competing for the global title', '2025-08-12T18:00:00', '2025-08-20T22:00:00', 'https://worldbasketball.example.com', '/images/basketball.jpg', 18743, 4.9, 85000, 'SPORTS');

-- Art exhibitions
INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('f5e7c8a1-4d62-4e3b-b2f9-1c9384a68d0e', 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'Modern Perspectives', '2024-10-15', '234 Gallery Road', 'New York', 'NY', '10011', 'USA', 'Contemporary art exhibition showcasing emerging artists exploring themes of technology and society', '2025-04-03T10:00:00', '2025-06-15T18:00:00', 'https://modernperspectives.example.gallery', '/images/modern_art.jpg', 4215, 4.5, 30000, 'EXHIBITION');

INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('5bf3f902-0593-48a3-95cf-4a512dbd77e2', '550e8400-e29b-41d4-a716-446655440000', 'Renaissance Reimagined', '2024-11-05', '567 Museum Avenue', 'Boston', 'MA', '02115', 'USA', 'Special exhibition featuring rarely seen Renaissance masterpieces with modern interpretations', '2025-02-10T09:30:00', '2025-05-10T17:30:00', 'https://renaissance.example.museum', '/images/renaissance.jpg', 7648, 4.9, 45000, 'EXHIBITION');

-- Food & culinary events
INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('683fd6e9-9a0e-4c6d-9993-5d9b27a64582', '6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'International Food Festival', '2024-08-12', '890 Culinary Boulevard', 'Portland', 'OR', '97204', 'USA', 'Celebration of global cuisine featuring over 200 food vendors, cooking demonstrations, and cultural performances', '2025-07-05T11:00:00', '2025-07-07T21:00:00', 'https://intlfoodfest.example.com', '/images/food_fest.jpg', 12543, 4.7, 60000, 'FOOD');

INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('79416129-1e3c-49c9-a132-b634e8b3abdc', 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'Wine & Cheese Expo', '2024-12-01', '432 Vineyard Lane', 'Napa', 'CA', '94559', 'USA', 'Premium tasting event featuring award-winning wines paired with artisanal cheeses from around the world', '2025-06-20T14:00:00', '2025-06-22T20:00:00', 'https://winecheese.example.net', '/images/wine_cheese.jpg', 5879, 4.8, 8000, 'FOOD');

-- Business & entrepreneurship
INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('8052fa62-7483-42e5-a14c-0faed9b8e3ec', '550e8400-e29b-41d4-a716-446655440000', 'Startup Summit 2025', '2024-10-20', '765 Venture Street', 'Denver', 'CO', '80202', 'USA', 'Premier networking event connecting entrepreneurs with investors and industry leaders', '2025-03-15T08:00:00', '2025-03-16T18:00:00', 'https://startupsummit.example.org', '/images/startup.jpg', 3562, 4.6, 5500, 'BUSINESS');

INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('9a63bcd1-8f36-4d37-8f37-c9aefa2b4a21', '6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'Women in Leadership Conference', '2024-09-05', '543 Empowerment Road', 'Washington', 'DC', '20001', 'USA', 'Annual gathering of women executives and aspiring leaders featuring workshops, keynotes, and mentoring opportunities', '2025-04-25T09:00:00', '2025-04-27T17:00:00', 'https://womenleaders.example.com', '/images/women_leaders.jpg', 8762, 4.9, 12000, 'CONFERENCE');

-- Cultural celebrations
INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('a72ef43c-d90b-4552-8932-6a6317c731df', 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'Lunar New Year Festival', '2024-12-10', '678 Heritage Plaza', 'San Francisco', 'CA', '94108', 'USA', 'Traditional celebration with dragon dances, cultural performances, and authentic cuisine', '2025-02-01T10:00:00', '2025-02-01T22:00:00', 'https://lunarfestival.example.org', '/images/lunar.jpg', 9546, 4.7, 75000, 'CULTURAL');

INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('b14d82e7-eb4a-4731-983f-7c2e278526a5', '550e8400-e29b-41d4-a716-446655440000', 'International Film Festival', '2024-07-20', '901 Cinema Street', 'Toronto', 'ON', 'M5V 2H1', 'Canada', 'Prestigious film festival showcasing independent films from around the world with director Q&A sessions', '2025-09-05T18:00:00', '2025-09-15T23:00:00', 'https://intlfilmfest.example.ca', '/images/film_fest.jpg', 14253, 4.8, 120000, 'CULTURAL');

-- Science & education
INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('c32f7a61-82c1-42d2-8901-93d89d776b7e', '6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'Space Exploration Symposium', '2024-11-25', '456 Cosmos Avenue', 'Houston', 'TX', '77058', 'USA', 'Scientific gathering featuring the latest discoveries in astronomy and space exploration with prominent scientists and astronauts', '2025-05-15T09:00:00', '2025-05-18T17:00:00', 'https://spacesymposium.example.org', '/images/space.jpg', 6842, 4.8, 4000, 'SCIENCE');

INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('d53e9b2f-7183-44e3-b090-8461ce9a9b31', 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'Climate Action Summit', '2024-08-30', '789 Sustainability Road', 'Stockholm', '111 44', '', 'Sweden', 'Global conference bringing together policymakers, scientists, and activists to address climate change solutions', '2025-04-22T08:30:00', '2025-04-24T18:30:00', 'https://climateaction.example.se', '/images/climate.jpg', 12387, 4.9, 3500, 'SCIENCE');

-- Wellness & lifestyle
INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('e729ca86-63d4-45f4-b28b-9572cea7ac24', '550e8400-e29b-41d4-a716-446655440000', 'Mindfulness Retreat', '2024-10-05', '321 Zen Path', 'Sedona', 'AZ', '86336', 'USA', 'Three-day wellness retreat featuring meditation sessions, yoga classes, and mindful living workshops', '2025-03-28T14:00:00', '2025-03-31T12:00:00', 'https://mindfulretreat.example.com', '/images/mindful.jpg', 3214, 4.7, 500, 'WELLNESS');

INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('f84ebf53-9278-46d5-a73c-b38dcf1a8815', '6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'Sustainable Living Expo', '2024-09-12', '654 Green Avenue', 'Vancouver', 'BC', 'V6B 5E3', 'Canada', 'Exhibition showcasing eco-friendly products, renewable energy solutions, and sustainable lifestyle practices', '2025-07-10T10:00:00', '2025-07-12T18:00:00', 'https://sustainexpo.example.ca', '/images/sustain.jpg', 7653, 4.6, 25000, 'EXHIBITION');

-- Gaming & entertainment
INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('69523724-06a9-47e6-b47d-c49fd2e89706', 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'Global Gaming Convention', '2024-11-15', '987 Player Avenue', 'Las Vegas', 'NV', '89109', 'USA', 'Massive gaming convention featuring new game releases, e-sports tournaments, and industry panels', '2025-06-05T09:00:00', '2025-06-08T19:00:00', 'https://gamingcon.example.com', '/images/gaming.jpg', 28764, 4.8, 150000, 'ENTERTAINMENT');

INSERT INTO events (id, accountid, name, creationdate, street, city, state, zip, country, description, startdatetime, enddatetime, websiteurl, imagekey, likes, rating, attendees, type)
VALUES ('10634835-17ba-58f7-c58e-d50fd3f90817', '550e8400-e29b-41d4-a716-446655440000', 'Comic & Fantasy Convention', '2024-07-30', '123 Hero Boulevard', 'San Diego', 'CA', '92101', 'USA', 'The worlds largest comic book and pop culture convention featuring artists, celebrities, and exclusive previews', '2025-07-24T10:00:00', '2025-07-28T19:00:00', 'https://comicfantasy.example.org', '/images/comic_con.jpg', 45398, 4.9, 200000, 'ENTERTAINMENT');