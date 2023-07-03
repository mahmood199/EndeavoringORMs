# EndeavoringORMs
## On my quest to find the best ORM support library on android

ORM libraries used in the project 
1. SQLDelight 
2. DBFlow
3. greenDAO
4. OrmLite
5. Sugar ORM


## Dao Items conflicy strategy
![image](https://github.com/mahmood199/EndeavoringORMs/assets/58071934/a44dd282-b0e8-4a6c-9737-d2529875806c)

## Conflict Strategy 
1. ABORT @Insert(onConflict = OnConflictStrategy.ABORT) / @Update(onConflict = OnConflictStrategy.ABORT)
 - If a constraint violation would occur from this statement, the statement is skipped. SQLiteDatabase throws a SQLiteConstraintException. However, if you have started a transaction, that transaction remains open, so further statements in the transaction can be executed. If anything in your @Transaction method throws an exception, of any kind, the entire transaction gets rolled back, courtesy of the try/finally structure. So, even though ABORT is supposed to keep the transaction open, Room rolls back the transaction, so that your @Transaction is atomic.

2. 


## LiveData and its issues with Room
1. Coroutines can be used for all kinds of DAO annotation functions (Query, Insert, Update, Delete) because they provide structured and sequential handling of asynchronous tasks. LiveData, on the other hand, is designed for observing data changes and is primarily used with query operations for real-time UI updates.

2. Using LiveData with Insert, Delete, or Update annotated functions would result in unexpected behavior or compilation errors, as LiveData is not designed to handle these operations. It is best to use coroutines or other asynchronous mechanisms for such operations without involving LiveData.

3. LiveData is not suitable for @Insert, @Update, or @Delete functions as it requires managing background threads separately. It always delivers results on the main thread, which can be inconvenient for scenarios like preparing database I/O before making a web service request. LiveData needs to be observed using a LifecycleOwner, which can be problematic in certain cases like services. Using observeForever() can bypass the need for a LifecycleOwner but requires careful removal of the Observer to avoid memory leaks. LiveData is lightweight and lacks comprehensive support for complex background operations, such as combining results from multiple sources. Its available facilities, like MediatorLiveData, can be challenging to use effectively.
