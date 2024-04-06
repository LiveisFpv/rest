INSERT INTO "portfolio"(
	id,profile_volume_usd,profile_volume_btc, current_volume_usd, current_volume_btc) VALUES
(1,
ARRAY[324.0,436.0,584.0,987.0,674.0],
ARRAY[324.0,436.0,584.0,987.0,674.0],
345,
345
);
INSERT INTO "coins"(
	id,coin_name, coin_code, price, h1, h24, d7, market_cap, volume, last_price) VALUES
(1,
'Bitcoin',
'BTC',
50000,
-25,
-23,
56,
2000000000,
400000000,
ARRAY[324, 436, 584, 987, 674]
);
INSERT INTO "coin"(
	id,portfolio_id, coin_name, coin_code, volume, usd_price, last_price) VALUES
(1,
1,
'Bitcoin',
'BTC',
34,
3289476278.0,
ARRAY[324, 436, 584, 987, 674]
);
INSERT INTO "deal"(
	id,portfolio_id, date, type, price, volume, coin_name, coin_code) values
(1,
1,
'2024-02-02T12:33:33',
'sell',
3543256,
3,
'Bitcoin',
'BTC'
);
INSERT INTO "exchanges"(
	id,name, score, volume24h, markets, "coins", last_volume) VALUES
(1,
'Binance',
9,
364578658725.0,
67,
45 ,
ARRAY[324,436,584,987,674]
);
INSERT INTO "trend"(
	id,coin_name, coin_code, h24) VALUES
(1,
'Bitcoin',
'BTC',
23
);