package core.generic;

import java.util.List;

public class DtoPrinter {
    public void execute() {

        List<UserDTO> userDTOs = List.of(new UserDTO(19L), new UserDTO(20L));
        printDTOs(userDTOs);

        List<ManagerDTO> managerDTOs = List.of(new ManagerDTO(21L), new ManagerDTO(22L));
        printDTOs(managerDTOs);

    }

    // READ
    public void printDTOs(List<? extends BaseDTO> dtos) {
        for (BaseDTO dto : dtos) {
            System.out.println("ID: " + dto.getId());
        }
    }


    interface BaseDTO {
        long getId();
    }

    public class UserDTO implements BaseDTO {
        private long id;

        public UserDTO(long id) {
            this.id = id;
        }

        @Override
        public long getId() {
            return id;
        }
    }

    public class ManagerDTO implements BaseDTO {
        private long id;

        public ManagerDTO(long id) {
            this.id = id;
        }

        @Override
        public long getId() {
            return id;
        }
    }

}
