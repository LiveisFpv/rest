INSERT INTO "Portfolio"(
	login, current_volume_usd, current_volume_btc) VALUES
(
'1',
345,
345
);
INSERT INTO "Coins"(
	coin_name, coin_code, price, h1, h24, d7, market_cup, volume, last_price) VALUES
('Bitcoin',
'BTC',
50000,
-25,
-23,
56,
2000000000,
400000000,
ARRAY[324, 436, 584, 987, 674]
);
INSERT INTO "Coin"(
	login, coin_name, coin_code, volume, usd_price, last_price) VALUES
('1',
'Bitcoin',
'BTC',
34,
3289476278.0,
ARRAY[324, 436, 584, 987, 674]
);
INSERT INTO "Deal"(
	login, date, type, price, volume, coin_name, coin_code) values
('1',
'2024-02-02T12:33:33',
'sell',
3543256,
3,
'Bitcoin',
'BTC'
);
INSERT INTO "Exchanges"(
	name, score, volume24h, markets, "Coins", last_volume) VALUES
(
'Binance',
9,
364578658725.0,
67,
45 ,
ARRAY[324,436,584,987,674]
);
INSERT INTO "Trend"(
	coin_name, coin_code, h24) VALUES
(
'Bitcoin',
'BTC',
23
);