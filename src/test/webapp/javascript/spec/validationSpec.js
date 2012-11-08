describe("bird name validation", function () {

    it("should not accept an empty entry", function () {

        var result = is_not_an_empty_field("");
        expect(result).not.toBe(true);
    });

    it("should accept a valid entry", function () {

        var result = is_not_an_empty_field("Pigeon");
        expect(result).toBe(true);
    });


    it("should not accept name with numbers", function () {
        var result = does_not_contain_numbers("Pigeon123");
        expect(result).not.toBe(true);
    });

    it("should not accept name with special characters", function () {
        var result = does_not_contain_special_characters("Pigeon&**");
        expect(result).not.toBe(true);
    });

    it("should accept a number and no text as number of birds", function () {
        var result = does_not_contain_numbers("1");
        expect(result).not.toBe(true);
    });

    it("should not accept zero as number of birds", function () {
        var result = contains_number_atleast_greater_than_zero("0");
        expect(result).not.toBe(true);
    });

    it("should not accept negative value as number of birds", function () {
        var result = contains_number_atleast_greater_than_zero("-2");
        expect(result).not.toBe(true);
    });

    it("should accept only digits as number of birds", function () {
        var result = is_a_valid_number("a1");
        expect(result).not.toBe(true);
    });


});
