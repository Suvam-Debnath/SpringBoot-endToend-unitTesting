<h1 align="center">🎬 Movie Service Unit Testing</h1>

<p align="center">
  🧪 This project demonstrates <b>unit testing of the MovieService layer</b> using
  <b>JUnit 5</b> and <b>Mockito</b>.
</p>

<hr>

<h2>🧪 Testing Scope</h2>
<ul>
  <li>🎯 Service layer testing only</li>
  <li>🧩 Repository layer is mocked</li>
  <li>🚫 No database or Spring context is used</li>
</ul>

<hr>

<h2>🛠 Tools & Technologies</h2>
<ul>
  <li>✅ <b>JUnit 5</b> – Test framework</li>
  <li>🎭 <b>Mockito</b> – Mocking dependencies</li>
  <li>🔌 <b>MockitoExtension</b> – Enables Mockito annotations</li>
  <li>📌 <b>AssertJ</b> – Fluent assertions</li>
</ul>

<hr>

<h2>📌 Key Annotations Used</h2>
<ul>
  <li>🧠 <code>@ExtendWith(MockitoExtension.class)</code> – Enables Mockito in JUnit 5</li>
  <li>🎭 <code>@Mock</code> – Mocks MovieRepository</li>
  <li>🧩 <code>@InjectMocks</code> – Injects mocked repository into MovieService</li>
  <li>🔄 <code>@BeforeEach</code> – Initializes test data before each test</li>
</ul>

<hr>

<h2>✅ Test Cases Covered</h2>
<ul>
  <li>💾 <b>Save Movie</b> – Verifies movie creation using mocked repository</li>
  <li>📋 <b>Get All Movies</b> – Ensures list of movies is returned correctly</li>
  <li>🔍 <b>Get Movie By ID</b> – Fetches movie when ID exists</li>
  <li>⚠️ <b>Get Movie By ID (Exception)</b> – Throws exception when movie not found</li>
  <li>✏️ <b>Update Movie</b> – Updates movie details and saves changes</li>
  <li>🗑️ <b>Delete Movie</b> – Deletes movie and verifies repository interaction</li>
</ul>

<hr>

<h2>🔍 Mocking Strategy</h2>
<ul>
  <li>🎬 <code>when(...).thenReturn(...)</code> for repository responses</li>
  <li>🧹 <code>doNothing()</code> for delete operations</li>
  <li>🔎 <code>verify()</code> to confirm repository method calls</li>
</ul>

<hr>

<h2>🎯 Purpose of Tests</h2>
<ul>
  <li>🛡️ Validate business logic in isolation</li>
  <li>✅ Ensure service methods behave correctly</li>
  <li>🔁 Prevent regressions during future changes</li>
</ul>

<hr>

<p align="center">
  🌟 <b>Well-structured unit tests improve code reliability and maintainability.</b>
</p>
