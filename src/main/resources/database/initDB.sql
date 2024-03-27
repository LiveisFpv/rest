BEGIN;

CREATE TABLE IF NOT EXISTS public."Coins"
(
    id BIGSERIAL NOT NULL,
    coin_name text NOT NULL,
    coin_code text NOT NULL,
    price double precision NOT NULL,
    h1 double precision NOT NULL,
    h24 double precision NOT NULL,
    d7 double precision NOT NULL,
    market_cup double precision NOT NULL,
    volume double precision NOT NULL,
    last_price double precision[] NOT NULL,
    CONSTRAINT "Coins_pkey" PRIMARY KEY (id,coin_code)
);

CREATE TABLE IF NOT EXISTS public."Deal"
(
    id BIGSERIAL NOT NULL,
    portfolio_id BIGSERIAL NOT NULL,
    date text NOT NULL,
    type text NOT NULL,
    price double precision NOT NULL,
    volume double precision NOT NULL,
    coin_name text NOT NULL,
    coin_code text NOT NULL,
    CONSTRAINT "Deal_pkey" PRIMARY KEY (id,portfolio_id)
);

CREATE TABLE IF NOT EXISTS public."Coin"
(
    id BIGSERIAL NOT NULL,
    portfolio_id BIGSERIAL NOT NULL,
    coin_name text NOT NULL,
    coin_code text NOT NULL,
    volume double precision NOT NULL,
    usd_price double precision NOT NULL,
    last_price double precision[] NOT NULL,
    CONSTRAINT "Coin_pkey" PRIMARY KEY (id,portfolio_id)
);

CREATE TABLE IF NOT EXISTS public."Trend"
(
    id BIGSERIAL NOT NULL,
    coin_name text NOT NULL,
    coin_code text NOT NULL,
    h24 double precision NOT NULL,
    CONSTRAINT "Trend_pkey" PRIMARY KEY (id,coin_code)
);

CREATE TABLE IF NOT EXISTS public."Portfolio"
(
    id BIGSERIAL NOT NULL,
    profile_volume_usd double precision[] NOT NULL,
    profile_volume_btc double precision[] NOT NULL,
    current_volume_usd double precision NOT NULL,
    current_volume_btc double precision NOT NULL,
    CONSTRAINT "Portfolio_pkey" PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public."Exchanges"
(
    id BIGSERIAL NOT NULL,
    name text NOT NULL,
    score double precision NOT NULL,
    volume24h double precision NOT NULL,
    markets double precision NOT NULL,
    "Coins" double precision NOT NULL,
    last_volume double precision[] NOT NULL,
    CONSTRAINT "Exchanges_pkey" PRIMARY KEY (id,name)
);
END;