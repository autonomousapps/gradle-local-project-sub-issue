
I would expect this to reproduce the issue:

```
cd consumer/
./gradlew a:test b:testFixturesJar
```

But it doesn't, and I'm not sure why.