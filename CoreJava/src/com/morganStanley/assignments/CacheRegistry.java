package com.morganStanley.assignments;

import java.util.concurrent.ConcurrentHashMap;


public class CacheRegistry {
	
	private static CacheRegistry cr;
	private final static int UPPER_THRESHOLD = 1024; //The threshold that will trigger cache garbage recycle;
	private final static int CLEAR_THRESHOLD = 10;//The threshold count for individual accountId to be cleared out of cache
	private static ConcurrentHashMap<String, Account> mapCache;//The cache that stores accounts;
	private static ConcurrentHashMap<String, Integer> mapCount;//The cache counter by id that is used for cache recycle;
	
	/**
	 * Constructor: CacheRegistry. Singleton. Can be instantiated in getInstance().
	 * params N/A
	 * */
	private CacheRegistry (){};
	
	/**
	 * getInstance(): returns an instance of CacheRegistry class if there are none. 
	 * Return the existing instance if an instance already exists.
	 * params N/A
	 * return CacheRegistry
	 * */
	public static CacheRegistry getInstance() {
		if(cr == null) {
			synchronized (CacheRegistry.class) {
				if(cr == null) {
					return new CacheRegistry();
				}
			}
		}
		return cr;
	};
	
	/**
	 * searchCache(): The base version of getting a cached query item.
	 * If target Account item exists in the cached mapCache, then return it;
	 * If not, fires a query and find it in database, then put it in the mapCache.
	 * The cacheCount will increase 1 by accountId that is being used.
	 * params String accountId: the id mark for target Account instance.
	 * returns Account
	 * */
	public Account searchCache(String accountId) {
		if(mapCache.get(accountId) == null) {
			//HttpGet get = new HttpGet("http:/morganstanley/api/accounts=?accountId");
			try{
				/*String resultStr = httpClient.execute(get, new BasicResponseHandler());
		        JSONObject result = new JSONObject(resultStr);
	            mapCache.put(result.getInt("accountId"), result.getJsonObject("Account"));
	            mapCount.put(result.getInt("accountId"), mapCount.put(accountId, mapCount.get(accountId) + 1));
	            */
	            sizeCheck();
			}
			catch (Exception e) {
		        throw new RuntimeException("Get Account Error!", e);
		    };
		    
		}
		return mapCache.get(accountId);
	}
	
	private void sizeCheck () {
		if(mapCache.size() > UPPER_THRESHOLD) {
			cacheGarbageRecycle();
		}
	}
	
	public void updateCache(String accountId, Account account) {
		if(mapCache.get(accountId) != null) {
			/**
			 * Check if the account obj is in cache, if it is, then update it in DB first;
			 * If the update in DB is successful then update it in local cache as well;
			 * If it is not in cache, then update it in DB then put it in cache as well.
			 * Meanwhile increase the corresponding cacheCount by 1. 
			 * If the update cannot find the account obj in neither cache or DB, throw 
			 * a resource not found exception. 
			 * */
		}
	}
	
	/**
	 * Clear the cache that has been used less than 10 times. If the cache are highly
	 * fragmented and most cache count are less than 10, then clear the cache by half.
	 * */
	private void cacheGarbageRecycle() {
		 mapCache.entrySet().stream()
	      .forEach(id -> {
	    	  if(mapCount.get(id) < CLEAR_THRESHOLD) {
	    		  mapCache.remove(id, mapCache.get(id));
	    	  }
	      });
		 //if mapCache.size() wasn't reduced enough, then clear cache by other rules.
	}
	


}

