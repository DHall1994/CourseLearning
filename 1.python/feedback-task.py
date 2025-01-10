# General comments
# Charles has good knowledge of programming principles and did well in this module. 
# He contributed to group discussion/questions and worked well in groups.  

# Learner Punctuality and engagement 
# Charles was always punctual throughout the module and engaged well with camera on. 

# Recommendations on further learning
# Continue to practice and explore good code design and start to specialise in 
# areas of interest. 

# user to input a list of names. 

# prompt the user for scores in the following areas (at least 2):
# - understanding level (1-5)
# - contribution level
# - lab completion level
# - engagament level
# - Punctuality level
# - furthe learning level

# dictionary to map scores to descriptive words. 

# template (string) "Gneral commnets/n{name} did {map[understanding_level]} in this module/n"
# template += "engagement and punctuality\n {name}....."
# template += ""

# output: 
# individual files for each students (student name is file name)
# optional - in its own directory

# optional stretch goal:
# - open the file for editing in a text editor for last minute changes/approval. 


# v1
# import os

# output_directory = input("Enter a name for the directory where files will be saved: ").strip()

# os.makedirs(output_directory, exist_ok=True)

# names = input("Enter a list of names separated by commas: ").split(",")

# for name in names:
#     understanding_level = int(input(f"Enter the understanding level for {name} (1-5): "))
#     contribution_level = int(input(f"Enter the contribution level for {name} (1-5): "))
#     lab_completion_level = int(input(f"Enter the lab completion level for {name} (1-5): "))
#     engagement_level = int(input(f"Enter the engagement level for {name} (1-5): "))
#     punctuality_level = int(input(f"Enter the punctuality level for {name} (1-5): "))
#     further_learning_level = int(input(f"Enter the further learning level for {name} (1-5): "))
    
#     score_map = {1: "poorly", 2: "below average", 3: "average", 4: "above average", 5: "excellently"}
    
#     template = f"General comments\n{name} has {score_map[understanding_level]} understanding of programming principles and did well in this module.\nHis contribution level to group discussion/questions is {score_map[contribution_level]}, there is room for improvement.\n"
#     template += "\n"
#     template += f"Lab completion\n{name} worked on several labs I gave them and completed those labs at a {score_map[lab_completion_level]} level.\n"
#     template += "\n"
#     template += f"Engagement and punctuality\n{name} was {score_map[engagement_level]} in engagement and {score_map[punctuality_level]} in punctuality, they was present each day but room for more engagement.\n"
#     template += "\n"
#     template += f"Further learning\n{name} showed {score_map[further_learning_level]} in further learning, when asked to go above and beyond the mandatory requirements.\n"

#     file_path = os.path.join(output_directory, f"{name}.txt")
#     with open(file_path, "w") as file:
#         file.write(template)
#         print(f"Feedback for {name} has been saved to {file_path}")
    

# v2
import os
import subprocess

score_map = {
    1: "poor",
    2: "below average",
    3: "average",
    4: "good",
    5: "excellent"
}

def generate_report(name, understanding_level, contribution_level, lab_completion_level, engagement_level, punctuality_level, further_learning_level):
    return f"""# General Comments
{name} has {score_map[understanding_level]} knowledge of programming principles and did {score_map[understanding_level]} in this module.
They contributed {score_map[contribution_level]} to group discussions and worked {score_map[contribution_level]} in groups. 


# Learner Punctuality and Engagement
{name} was {score_map[punctuality_level]} punctual throughout the module and engaged {score_map[engagement_level]}.


# Recommendations on Further Learning
Continue to practice and explore good code design and start to specialise in areas of interest.


# Lab Completion
{name} completed labs {score_map[lab_completion_level]}.


# Additional Comments
{name} has shown {score_map[further_learning_level]} potential for further learning and improvement.
"""

# Defines output directory location (maybe add timestamp?)
output_dir = "student_reports"
# Makes the directory
os.makedirs(output_dir, exist_ok=True)

# Input names and sanitise
names = [name.strip() for name in input("Enter a list of names separated by commas: ").split(",")]

for name in names:
    understanding_level = int(input(f"Enter the understanding level for {name} (1-5): "))
    contribution_level = int(input(f"Enter the contribution level for {name} (1-5): "))
    lab_completion_level = int(input(f"Enter the lab completion level for {name} (1-5): "))
    engagement_level = int(input(f"Enter the engagement level for {name} (1-5): "))
    punctuality_level = int(input(f"Enter the punctuality level for {name} (1-5): "))
    further_learning_level = int(input(f"Enter the further learning level for {name} (1-5): "))

    # Generate the report
    report = generate_report(name, understanding_level, contribution_level, lab_completion_level, engagement_level, punctuality_level, further_learning_level)
    
    # Sanitise the filename (fixes errors with opening)
    filename = "".join(c for c in name if c.isalnum() or c in (' ', '-', '_')).strip().replace(" ", "_")
    file_path = os.path.join(output_dir, f"{filename}.txt")
    
    # Write the report to a file
    with open(file_path, "w") as file:
        file.write(report)
    print(f"Report created for {name} at {file_path}")

open_for_edit = input("\nDo you want to review and edit the reports one by one? (yes/no): ").lower()
if open_for_edit == "yes":
    for name in names:
        name = name.strip()
        filename = "".join(c for c in name if c.isalnum() or c in (' ', '-', '_')).strip().replace(" ", "_")
        file_path = os.path.join(output_dir, f"{filename}.txt")
        print(f"\nOpening report for {name}...")
        
        # Open the file for editing based on the platform
        if os.name == 'nt':  # Windows
            os.startfile(file_path)
        elif os.name == 'posix':  # macOS/Linux
            subprocess.run(["open", file_path] if "darwin" in os.uname().sysname.lower() else ["xdg-open", file_path])
        
        # Ask if the user wants to continue to the next file
        proceed = input("Press Enter to continue to the next report, or type 'exit' to stop: ").lower()
        if proceed == "exit":
            print("Exiting file review.")
            break
    