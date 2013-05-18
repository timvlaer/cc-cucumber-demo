Feature: Bezoekers van de Axxes website moeten op de startpagina onmiddellijk onze contactgegevens terugvinden.

  Scenario: Op de startpagina staat ons adres en telefoonnummer.
    When ik surf naar de axxes startpagina op 'http://www.axxes-it.com/nl'
    Then moet de pagina de tekst 'Entrepotkaai 10A' bevatten
    And moet de pagina de tekst '+32 3 234 99 58' bevatten
