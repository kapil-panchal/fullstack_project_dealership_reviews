SELECT DISTINCT app30sch.person.first_name,
                app30sch.car.make

FROM app30sch.person_car
JOIN app30sch.person
ON app30sch.person_car.person_id = app30sch.person.person_id

JOIN app30sch.car
ON app30sch.person_car.car_id = app30sch.car.car_id

WHERE app30sch.person.first_name = 'Abcd';