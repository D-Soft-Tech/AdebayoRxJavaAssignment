private lateinit var input: ArrayList<Int>
        
        val disposable = CompositeDisposable()

        for (i in 1..100) {
            input.add(i)
        }

        var result = Observable.just(input)
            .toFlowable(BackpressureStrategy.DROP)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { it -> println(it) }

        disposable.add(result)
